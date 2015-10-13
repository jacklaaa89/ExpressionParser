package org.expression;

import org.expression.parser.Visitor;
import org.expression.parser.ErrorHandler;
import org.expression.computation.Evaluator;
import org.expression.computation.Handler;
import org.expression.computation.Arithmetic;
import org.expression.computation.Functions;
import org.expression.computation.Function;
import org.expression.computation.Operator;
import org.expression.structure.Matrix;
import org.expression.structure.Vector;
import org.expression.structure.Structure;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.expression.computation.linear.LinearSystemSolver;
import org.expression.parser.ExpressionLexer;
import org.expression.parser.ExpressionParser;
import org.expression.structure.Predicate;

/**
 * The Expression class which is an encapsulation of an expression to parse.
 * We can set the precision and rounding mode to use in the MathContext when parsing the
 * expression.
 * We can also parse boolean expressions which respectfully return a 0 or 1 which can be
 * evaluated to FALSE or TRUE.
 * @author Jack Timblin 
 */
public class Expression {
    
    /**
     * A collection of the functions which are available.
     * i.e log, sin, tan, round etc.
     */
    private final HashMap<String, Function> functions;
    
    /**
     * The expression to parse.
     */
    private String expression;
    
    /**
     * A collection of the operators available.
     * i.e +, /, *, -, ^, % etc
     */
    private final HashMap<String, Operator> operators;
    
    /**
     * A collection of the variables / constants which are available.
     * i.e PI, TRUE, FALSE, x, y etc
     */
    private final HashMap<String, Type> variables;
    
    /**
     * The currently defined MathContext.
     * Sets the precision and rounding mode to use during calculation.
     */
    private MathContext mc;
    
    /**
     * A reference to the PI constant.
     * the ratio of the circumference of a circle to its diameter.
     */
    public static final double PI = Math.PI;
    
    /**
     * A reference to boolean TRUE.
     * represented as a absolute 1.
     */
    public static final Scalar TRUE = Scalar.ONE;
    
    /**
     * A reference to boolean FALSE.
     * represented as a absolute 0.
     */
    public static final Scalar FALSE = Scalar.ZERO;
    
    public Expression() {
        this(null);
    }
    
    /**
     * Initializes a new Expression and adds all of the core operators, variables and functions.
     * @param expression The expression to parse.
     */    
    public Expression(String expression) {
        
        //Initialize the data collections.
        this.functions = new HashMap<>();
        this.expression = expression;
        this.operators = new HashMap<>();
        this.variables = new HashMap<>();
        
        //set the default math context.
        this.mc = MathContext.DECIMAL32;
        
        //Logarithm functions.
        addFunction("log", Functions.LOG);
        addFunction("log10", Functions.LOG10);
        
        //Sine, Cosine & Tangent functions.
        addFunction("sin", Functions.SIN);
        addFunction("cos", Functions.COS);
        addFunction("tan", Functions.TAN);
        addFunction("asin", Functions.ASIN);
        addFunction("atan", Functions.ATAN);
        addFunction("acos", Functions.ACOS);
        addFunction("sinh", Functions.SINH);
        addFunction("cosh", Functions.COSH);
        addFunction("tanh", Functions.TANH);
        
        //Converter functions.
        addFunction("rad", Functions.RAD);
        addFunction("deg", Functions.DEG);
        addFunction("abs", Functions.ABS);
        addFunction("floor", Functions.FLOOR);
        addFunction("ceiling", Functions.CEILING);
        
        addFunction(new Function("random", 0){
            @Override
                public Type eval(List<Type> args) {
                    
                    if(args.isEmpty()) {
                        return Scalar.random();
                    }
                    
                    Type r = args.get(0);
                    if(r instanceof Matrix) {
                        throw new RuntimeException("cannot have a matrix as a parameter");
                    }
                    Type m;
                    if(r instanceof Vector) {
                        Vector v = (Vector) r;
                        if(v.isEmpty()) {
                            throw new RuntimeException("need at least one value in the vector.");
                        }
                        //we are generating a random matrix.
                        //if we have at least two entries.
                        //or an array if we have one entry more than 1.
                        //or a single value if 1.
                        if(v.size() >= 2) {
                           m = Matrix.random(v.get(0).intValue(), v.get(1).intValue());
                        } else {
                           int amount = v.get(0).intValue();
                           m = (amount <= 1) ? Scalar.random() : Vector.random(amount);
                        }
                    } else {
                        //we have a whole number.
                        Scalar n = (Scalar) r;
                        int amount = n.intValue();
                        m = (amount <= 1) ? Scalar.random() : Vector.random(amount);
                    }
                    return m;
                }
            }
        );
        
        addFunction(new Function("max", 1){
            @Override
                public Type eval(List<Type> args) throws ClassCastException {
                    return ((Arithmetic) args.get(0)).max();
                }
            }
        );
        
        addFunction(new Function("min", 1){
            @Override
                public Type eval(List<Type> args) throws ClassCastException {
                    return ((Arithmetic) args.get(0)).min();
                }
            }
        );
        
        addFunction(new Function("round", 2){
            @Override
                public Type eval(List<Type> args) throws ClassCastException {
                    Type r = args.get(0);
                    Scalar p = (Scalar) args.get(1);
                    
                    int precision = p.intValue();
                    Handler hndlr = (Handler) (Scalar o1, MathContext mc) -> {
                        BigDecimal d = new BigDecimal(o1.value);
                        return new Scalar(d.setScale(precision, mc.getRoundingMode()).doubleValue());
                    };
                    return r.apply(hndlr);
                }
            }
        );
        
        addFunction(new Function("sum", 1) {
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                return ((Arithmetic) args.get(0)).sum();
            }
        });
        
        //Matrix functions.
        addFunction(new Function("transpose", 1) {
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix c = (Matrix) args.get(0);
                return c.transpose();
            }
        });
        
        addFunction(new Function("identity", 1){
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Scalar c = (Scalar) args.get(0);
                return Matrix.identity(c.intValue());
            }
        });
        
        addFunction(new Function("square", 1){
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix m = (Matrix) args.get(0);
                return m.is(Predicate.SQUARE) ? Scalar.ONE : Scalar.ZERO;
            }
        });
        
        addFunction(new Function("diagonally_dominant", 1){
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix m = (Matrix) args.get(0);
                return m.is(Predicate.DIAGONALLY_DOMINANT) ? Scalar.ONE : Scalar.ZERO;
            }
        });
        
        addFunction(new Function("det", 1){
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix m = (Matrix) args.get(0);
                return m.determinant();
            }
        });
        
        addFunction(new Function("rank", 1) {
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix m = (Matrix) args.get(0);
                return m.rank();
            }
        });
        
        addFunction(new Function("row", 2) {
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix m = (Matrix) args.get(0);
                Vector n = (Vector) args.get(1);
                Scalar i  = (args.size() > 2) 
                        ? ((Scalar)args.get(2))
                        : new Scalar(m.getRowSize());
                return m.addRow(i.intValue(), n);
            }
        });
        
        addFunction(new Function("gaussian", 2) {
            @Override
            public Type eval(List<Type> args) {
                Matrix A = (Matrix) args.get(0);
                Vector b = (Vector) args.get(1);
                return A.solve(LinearSystemSolver.GAUSSIAN_ELIMINATION, b);
            }
        });
        
        addFunction(new Function("lu", 2){
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix A = (Matrix) args.get(0);
                Vector b = (Vector) args.get(1);
                return A.solve(LinearSystemSolver.LU, b);
            }
        });
        
        addFunction(new Function("qr", 2) {
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix A = (Matrix) args.get(0);
                Vector b = (Vector) args.get(1);
                return A.solve(LinearSystemSolver.LEAST_SQUARES, b);
            }
        });
        
        addFunction(new Function("column", 2){
            @Override
            public Type eval(List<Type> args) {
                Type r = args.get(0);
                Type a = args.get(1);
                Scalar index = (args.size() > 2 && args.get(2) instanceof Scalar)
                        ? (Scalar) args.get(2)
                        : null;
                if(index == null) {
                    if(r instanceof Matrix && a instanceof Vector) {
                        index = new Scalar(((Matrix)r).getColumnSize());
                    } else if(r instanceof Vector && a instanceof Scalar) {
                        index = new Scalar(((Vector)r).size());
                    } else {
                        throw new ArithmeticException("invalid parameter types");
                    }
                }
                return ((Structure)r).addColumn(index.intValue(), a);
            }
        });
        
        addFunction(new Function("size", 1){
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Type t = args.get(0);
                if(t instanceof Vector) {
                    return new Scalar((double)((Vector) t).size());
                } else {
                    return ((Matrix)t).getDimensions();
                }
            }
        });
        
        addFunction(new Function("slice", 3) {
            @Override
            public Type eval(List<Type> args) {
                Type r = args.get(0);
                Type s = args.get(1);
                Type e = args.get(2);
                Coordinate start; Coordinate end;
                if(s instanceof Scalar && e instanceof Scalar && r instanceof Vector) {
                    start = new Coordinate((Scalar)s);
                    end = new Coordinate((Scalar)e);
                } else if(s instanceof Vector && e instanceof Vector && r instanceof Matrix) {
                    start = new Coordinate((Vector)s); 
                    end = new Coordinate((Vector)e);
                } else {
                    throw new ArithmeticException("invalid parameter types");
                }
                return ((Structure)r).slice(start, end);
            }
        });
        
        addFunction(new Function("sqrt", 1){
                @Override
                public Type eval(List<Type> args) {
                    Scalar x = (Scalar) args.get(0);
                    double y = Math.sqrt(x.value);
                    return new Scalar(y);
                }
            }
        );
        
        addFunction(new Function("print", 1) {
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                System.out.println(args.get(0));
                return null;
            }
        });
        
        addOperator(new Operator("<<")
            .addEvaluator(
                new int[] {
                    Operator.EXPRESSION_SCALAR,
                    Operator.EXPRESSION_VECTOR_SCALAR,
                    Operator.EXPRESSION_MATRIX_SCALAR
                },
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    return left.bitwiseLeft((Scalar)right);
                }
            )
        );
        
        addOperator(new Operator(">>")
            .addEvaluator(
                new int[] {
                    Operator.EXPRESSION_SCALAR,
                    Operator.EXPRESSION_VECTOR_SCALAR,
                    Operator.EXPRESSION_MATRIX_SCALAR
                },
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    return left.bitwiseRight((Scalar)right);
                }
            )
        );
        
        addOperator(new Operator("%")
            .addEvaluator(
                Operator.EXPRESSION_ALL, 
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    return left.remainder(right);
                }   
            )
            .removeEvaluator(Operator.EXPRESSION_VECTOR_MATRIX)
        );
        
        addOperator(new Operator("+")
            .addEvaluator(
                Operator.EXPRESSION_ALL, 
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    return left.add(right);
                }   
            )
            //not valid for vector to matrix operations.
            .removeEvaluator(Operator.EXPRESSION_VECTOR_MATRIX)
        );
        
        addOperator(new Operator("*")
            .addEvaluator(
                Operator.EXPRESSION_ALL, 
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    return left.multiply(right);
                }   
            )
            //not valid for vector to matrix operations.
            .removeEvaluator(Operator.EXPRESSION_VECTOR_MATRIX)
        );
        
        addOperator(new Operator("-")
            .addEvaluator(
                Operator.EXPRESSION_ALL, 
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    return left.subtract(right);
                }   
            )
            //not valid for vector to matrix operations.
            .removeEvaluator(Operator.EXPRESSION_VECTOR_MATRIX)
        );
        
        addOperator(new Operator("^")
            .addEvaluator(
                Operator.EXPRESSION_SCALAR, 
                (Evaluator<Scalar>) (Arithmetic lleft, Arithmetic rright) -> {
                    return ((Scalar)lleft).power((Scalar)rright);
                }   
            )
            .addEvaluator(Operator.EXPRESSION_MATRIX_SCALAR,
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    Matrix m = (Matrix) left;
                    return m.power(((Scalar)right).intValue());
                }
            )
        );
        
        addOperator(new Operator("/")
            .addEvaluator(
                Operator.EXPRESSION_ALL,
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    return left.divide(right);
                }
            )
        );
        
        addOperator(new Operator("||")
            .addEvaluator(
                Operator.EXPRESSION_SCALAR, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    boolean bl = !left.equals(Scalar.ZERO);
                    boolean br = !right.equals(Scalar.ZERO);
                    return bl || br ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .addEvaluator(
                Operator.EXPRESSION_VECTOR, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    boolean bl = !left.equals(Vector.zeroes(((Vector)left).size()));
                    boolean br = !right.equals(Vector.zeroes(((Vector)left).size()));
                    return bl || br ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .addEvaluator(
                Operator.EXPRESSION_MATRIX, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    Matrix ml = (Matrix) left;
                    Matrix mr = (Matrix) right;
                    boolean bl = !left.equals(Matrix.zeroes(ml.getRowSize(), ml.getColumnSize()));
                    boolean br = !right.equals(Matrix.zeroes(mr.getRowSize(), mr.getColumnSize()));
                    return bl || br ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .addEvaluator(
                Operator.EXPRESSION_MATRIX_SCALAR, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    Matrix ml = (Matrix) left;
                    boolean bl = !left.equals(Matrix.zeroes(ml.getRowSize(), ml.getColumnSize()));
                    boolean br = !right.equals(Scalar.ZERO);
                    return bl || br ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .addEvaluator(
                Operator.EXPRESSION_VECTOR_SCALAR, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    Vector ml = (Vector) left;
                    boolean bl = !left.equals(Vector.zeroes(ml.size()));
                    boolean br = !right.equals(Scalar.ZERO);
                    return bl || br ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .addEvaluator(
                Operator.EXPRESSION_MATRIX_VECTOR, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    Matrix ml = (Matrix) left;
                    Vector mr = (Vector) right;
                    boolean bl = !left.equals(Matrix.zeroes(ml.getRowSize(), ml.getColumnSize()));
                    boolean br = !right.equals(Vector.zeroes(mr.size()));
                    return bl || br ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .addEvaluator(
                Operator.EXPRESSION_VECTOR_MATRIX, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    return (Scalar) operators.get("||")
                            .getEvaluator(Operator.EXPRESSION_MATRIX_VECTOR)
                            .eval(left, right);
                }   
            )
        );
        
        addOperator(new Operator("&&")
            .addEvaluator(
                Operator.EXPRESSION_SCALAR, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    boolean bl = !left.equals(Scalar.ZERO);
                    boolean br = !right.equals(Scalar.ZERO);
                    return bl && br ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .addEvaluator(
                Operator.EXPRESSION_VECTOR, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    boolean bl = !left.equals(Vector.zeroes(((Vector)left).size()));
                    boolean br = !right.equals(Vector.zeroes(((Vector)left).size()));
                    return bl && br ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .addEvaluator(
                Operator.EXPRESSION_MATRIX, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    Matrix ml = (Matrix) left;
                    Matrix mr = (Matrix) right;
                    boolean bl = !left.equals(Matrix.zeroes(ml.getRowSize(), ml.getColumnSize()));
                    boolean br = !right.equals(Matrix.zeroes(mr.getRowSize(), mr.getColumnSize()));
                    return bl && br ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .addEvaluator(
                Operator.EXPRESSION_MATRIX_SCALAR, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    Matrix ml = (Matrix) left;
                    boolean bl = !left.equals(Matrix.zeroes(ml.getRowSize(), ml.getColumnSize()));
                    boolean br = !right.equals(Scalar.ZERO);
                    return bl && br ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .addEvaluator(
                Operator.EXPRESSION_VECTOR_SCALAR, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    Vector ml = (Vector) left;
                    boolean bl = !left.equals(Vector.zeroes(ml.size()));
                    boolean br = !right.equals(Scalar.ZERO);
                    return bl && br ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .addEvaluator(
                Operator.EXPRESSION_MATRIX_VECTOR, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    Matrix ml = (Matrix) left;
                    Vector mr = (Vector) right;
                    boolean bl = !left.equals(Matrix.zeroes(ml.getRowSize(), ml.getColumnSize()));
                    boolean br = !right.equals(Vector.zeroes(mr.size()));
                    return bl && br ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .addEvaluator(
                Operator.EXPRESSION_VECTOR_MATRIX, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    return (Scalar) operators.get("&&")
                            .getEvaluator(Operator.EXPRESSION_MATRIX_VECTOR)
                            .eval(left, right);
                }   
            )
        );
        
        //define a default evaluator which just returns zero (FALSE)
        Evaluator<Scalar> def = (Arithmetic left, Arithmetic right) -> {
            return Scalar.ZERO;
        };
        
        addOperator(new Operator("<")
            .addEvaluator(
                Operator.EXPRESSION_SYMMETRIC, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    return left.compareTo(right) == -1 ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .setDefaultEvaluator(def)
        );
        
        addOperator(new Operator(">")
            .addEvaluator(
                Operator.EXPRESSION_SYMMETRIC, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    return left.compareTo(right) == 1 ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .setDefaultEvaluator(def)
        );
        
        addOperator(new Operator(">=")
            .addEvaluator(
                Operator.EXPRESSION_SYMMETRIC, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    return left.compareTo(right) >= 1 ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .setDefaultEvaluator(def)
        );
        
        addOperator(new Operator("<=")
            .addEvaluator(
                Operator.EXPRESSION_SYMMETRIC, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    return left.compareTo(right) <= 1 ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .setDefaultEvaluator(def)
        );
        
        addOperator(new Operator("==")
            .addEvaluator(
                Operator.EXPRESSION_SYMMETRIC, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    return left.equals(right) ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .setDefaultEvaluator(def)
        );
        
        addOperator(new Operator("!=")
            .addEvaluator(
                Operator.EXPRESSION_SYMMETRIC, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    return !left.equals(right) ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .setDefaultEvaluator(def)
        );
        
        //add the core variables.
        addVariable("PI", PI);
        addVariable("FALSE", FALSE);
        addVariable("TRUE", TRUE);
        
        //set the default precision and rounding mode.
        setPrecision(14); setRoundingMode(RoundingMode.HALF_EVEN);
        
    }
    
    /**
     * Sets the precision to use.
     * @param precision the precision to use.
     * @return a reference to itself for method chaining.
     * @deprecated 
     */
    public final Expression setPrecision(int precision) {
        RoundingMode m = RoundingMode.HALF_EVEN;
        if(this.mc != null) {
            m = this.mc.getRoundingMode();
        }
        this.mc = new MathContext(precision, m);
        return this;
    }
    
    /**
     * Sets the rounding mode to use.
     * @param mode the rounding mode to use.
     * @return a reference to itself for method chaining.
     * @deprecated
     */
    public final Expression setRoundingMode(RoundingMode mode) {
        int precision = 7;
        if(this.mc != null) {
            precision = this.mc.getPrecision();
        }
        this.mc = new MathContext(precision, mode);
        return this;
    }
    
    public final Expression addFunction(String name, Functions function) {
        Function f = new Function(name, 1) {
            @Override
            public Type eval(List<Type> args) {
                Type r = args.get(0);
                return r.apply(function);
            }
        };
        return this.addFunction(f);
    }
    
    /**
     * Adds a function to use.
     * @param function the function to use.
     * @return a reference to itself for method chaining.
     */
    public final Expression addFunction(Function function) {
        this.functions.put(function.getName(), function);
        return this;
    }
    
    /**
     * Get the expression that we are evaluating.
     * @return the expression we are evaluating.
     */
    public String getExpression() {
        return this.expression;
    }
    
    /**
     * Adds a new operator to use.
     * @param operator the operator to use
     * @return a reference to itself for method chaining.
     */
    public final Expression addOperator(Operator operator) {
        this.operators.put(operator.getOper(), operator);
        return this;
    }
    
    /**
     * Adds a new variable to use.
     * @param variableName the name of this variable as defined in the expression.
     * @param value the value of this variable.
     * @return a reference to itself for method chaining.
     */
    public final Expression addVariable(String variableName, Type value) {
        this.variables.put(variableName, value);
        return this;
    }
    
    /**
     * Adds a new variable to use.
     * @param variableName the name of this variable as defined in the expression.
     * @param value the value of this variable.
     * @return a reference to itself for method chaining.
     */
    public final Expression addVariable(String variableName, double value) {
        this.addVariable(variableName, new Scalar(value, mc));
        return this;
    }
    
    public final Expression setExpression(String expression) {
        this.expression = expression;
        return this;
    }
    
    /**
     * Adds a new variable to use.
     * @param variableName the name of this variable as defined in the expression.
     * @param value the value of this variable.
     * @return a reference to itself for method chaining.
     */
    public final Expression addVariable(String variableName, int value) {
        this.addVariable(variableName, (double) value);
        return this;
    }
    
    /**
     * Attempts to evaluate the expression.
     * @return the evaluated result to the defined MathContext's specification.
     * @throws RuntimeException if an error is reported by the error handler, i.e a syntax error etc.
     */
    public Context eval() throws RuntimeException {
        
        if(this.expression == null || this.expression.isEmpty()) {
            throw new IllegalArgumentException("no valid expression was defined");
        }
        
        ANTLRInputStream stream = new ANTLRInputStream(this.expression);
        ExpressionLexer lexer = new ExpressionLexer(stream);
        ErrorHandler handler = new ErrorHandler();
        lexer.removeErrorListeners();
        lexer.addErrorListener(handler);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(handler);
        ParseTree tree = parser.start();
        
        Visitor ve = new Visitor(functions, operators, variables, mc);
        Context c = ve.visit(tree);
        
        if(c == null || c.getValue() == null) {
            throw new RuntimeException("a unexpected error occured.");
        }
        
        return c;
    }

    
}
