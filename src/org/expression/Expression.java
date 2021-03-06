package org.expression;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
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
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.expression.computation.FixedOperator;
import org.expression.computation.linear.LinearSystemSolver;
import org.expression.output.ConsoleOutput;
import org.expression.output.OutputListener;
import org.expression.parser.Context;
import org.expression.parser.ExpressionException;
import org.expression.parser.ExpressionLexer;
import org.expression.parser.ExpressionParser;
import org.expression.structure.Predicate;

/**
 * The Expression class which is an encapsulation of an expression to parse.
 * We can also parse boolean expressions which respectfully return a 0 or 1 which can be
 * evaluated to FALSE or TRUE.
 * @author Jack Timblin 
 */
public class Expression {
    
    /**
     * A collection of the functions which are available.
     * i.e log, sin, tan, round etc.
     */
    private HashMap<String, Function> functions;
    
    /**
     * The expression to parse.
     */
    private CharStream expression;
    
    /**
     * A collection of the operators available.
     * i.e +, /, *, -, ^, % etc
     */
    private HashMap<String, Operator> operators;
    
    /**
     * A collection of the operators available for postfix operations.
     * i.e. ++/-- operations.
     */
    private HashMap<String, Operator> postfixOperators;
    
    /**
     * A collection of the operators available for prefix operations.
     * i.e. ++/-- operations.
     */
    private HashMap<String, Operator> prefixOperators;
    
    /**
     * A collection of the variables / constants which are available.
     * i.e PI, TRUE, FALSE, x, y etc
     */
    private HashMap<String, Type> variables;
    
    /**
     * The output listener to use when outputting print statements.
     */
    private OutputListener listener;
    
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
        this.initialize();
    }
    
    /**
     * Initializes a new Expression and adds all of the core operators, variables and functions.
     * @param expression The expression to parse.
     */    
    public Expression(String expression) {
        if(expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("invalid expression");
        }
        this.expression = new ANTLRInputStream(expression);
        this.initialize();
    }
    
    /**
     * Initializes a new Expression and adds all of the core operators, variables and functions.
     * @param source The expression source file to parse.
     */
    public Expression(File source) {
        if(!source.exists() || source.isDirectory()) {
            throw new RuntimeException("source file must exist.");
        }
        if(!this.validFileExtension(source)) {
            throw new RuntimeException("invalid file extension.");
        }
        try {
            this.expression = new ANTLRFileStream(source.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        this.initialize();
    }
    
    /**
     * Initializes the Expression class, adding all of the core operations, variables and functions.
     */
    private void initialize() {
        //Initialize the data collections.
        this.functions = new HashMap<>();
        this.operators = new HashMap<>();
        this.postfixOperators = new HashMap<>();
        this.prefixOperators = new HashMap<>();
        this.variables = new HashMap<>();
        this.listener = new ConsoleOutput();
        
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
        
        //random function, generates a Scalar, Vector or Matrix with
        //random values between 0 and 1.
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
        
        //gets the largest value in a data structure.
        addFunction(new Function("max", 1){
            @Override
                public Type eval(List<Type> args) throws ClassCastException {
                    return ((Arithmetic) args.get(0)).max();
                }
            }
        );
        
        //gets the smallest value in a data structure.
        addFunction(new Function("min", 1){
            @Override
                public Type eval(List<Type> args) throws ClassCastException {
                    return ((Arithmetic) args.get(0)).min();
                }
            }
        );
        
        //rounds all of the values (or value) to the provided precision.
        addFunction(new Function("round", 2){
            @Override
                public Type eval(List<Type> args) throws ClassCastException {
                    Type r = args.get(0);
                    Scalar p = (Scalar) args.get(1);
                    
                    int precision = p.intValue();
                    Handler hndlr = (Handler) (Scalar o1) -> {
                        BigDecimal d = new BigDecimal(o1.value);
                        return new Scalar(d.setScale(precision, RoundingMode.UNNECESSARY).doubleValue());
                    };
                    return r.apply(hndlr);
                }
            }
        );
        
        //determines the sum of all the values in a data structure.
        addFunction(new Function("sum", 1) {
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                return ((Arithmetic) args.get(0)).sum();
            }
        });
        
        //Calculates the transpose of a Matrix.
        addFunction(new Function("transpose", 1) {
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix c = (Matrix) args.get(0);
                return c.transpose();
            }
        });
        
        //generates a new identity matrix with n values.
        addFunction(new Function("identity", 1){
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Scalar c = (Scalar) args.get(0);
                return Matrix.identity(c.intValue());
            }
        });
        
        //generates a scalar matrix of n values.
        addFunction(new Function("scalar", 2) {
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Scalar m = (Scalar) args.get(0);
                Scalar n = (Scalar) args.get(1);
                return Matrix.scalar(m.intValue(), n);
            }
        });
        
        //determines if a matrix is square.
        addFunction(new Function("square", 1){
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix m = (Matrix) args.get(0);
                return m.is(Predicate.SQUARE) ? Scalar.ONE : Scalar.ZERO;
            }
        });
        
        //determines if a matrix is diagonally dominant
        addFunction(new Function("diagonally_dominant", 1){
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix m = (Matrix) args.get(0);
                return m.is(Predicate.DIAGONALLY_DOMINANT) ? Scalar.ONE : Scalar.ZERO;
            }
        });
        
        //calculates the determinant of a matrix.
        addFunction(new Function("det", 1){
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix m = (Matrix) args.get(0);
                return m.determinant();
            }
        });
        
        //determines the rank of a matrix.
        addFunction(new Function("rank", 1) {
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix m = (Matrix) args.get(0);
                return m.rank();
            }
        });
        
        //inserts a new row into a matrix or a single entry into a vector.
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
        
        //Attempts to solve a system of equations using guassian elimination.
        addFunction(new Function("gaussian", 2) {
            @Override
            public Type eval(List<Type> args) {
                Matrix A = (Matrix) args.get(0);
                Vector b = (Vector) args.get(1);
                return A.solve(LinearSystemSolver.GAUSSIAN_ELIMINATION, b);
            }
        });
        
        //Attempts to solve a system of equations using LU factorization.
        addFunction(new Function("lu", 2){
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix A = (Matrix) args.get(0);
                Vector b = (Vector) args.get(1);
                return A.solve(LinearSystemSolver.LU, b);
            }
        });
        
        //Attempts to solve a system of equations using QR factorization.
        addFunction(new Function("qr", 2) {
            @Override
            public Type eval(List<Type> args) throws ClassCastException {
                Matrix A = (Matrix) args.get(0);
                Vector b = (Vector) args.get(1);
                return A.solve(LinearSystemSolver.LEAST_SQUARES, b);
            }
        });
        
        //adds a new column into a matrix or a new entry in a vector.
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
        
        //determines the size of a data structure.
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
        
        //attempts to retrieve a slice of a data structure from n to m.
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
        
        //attempts to determine the square root of a value.
        addFunction(new Function("sqrt", 1){
                @Override
                public Type eval(List<Type> args) {
                    Scalar x = (Scalar) args.get(0);
                    double y = Math.sqrt(x.value);
                    return new Scalar(y);
                }
            }
        );
        
        addOperator(new FixedOperator("++", FixedOperator.POSTFIX)
            .addEvaluator(
                Operator.EXPRESSION_ALL, 
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    return left.increment(); //++ now adds two by default.
                }
            )
        );
        
        addOperator(new FixedOperator("--", FixedOperator.POSTFIX)
            .addEvaluator(
                Operator.EXPRESSION_ALL, 
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    return left.decrement();
                }
            )
        );
        
        addOperator(new FixedOperator("++", FixedOperator.PREFIX)
            .addEvaluator(
                Operator.EXPRESSION_ALL, 
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    return left.add(left); //++ prefix adds left to left.
                }
            )
        );
        
        addOperator(new FixedOperator("--", FixedOperator.PREFIX)
            .addEvaluator(
                Operator.EXPRESSION_ALL, 
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    return left.subtract(left);
                }
            )
        );
        
        //bitwise left operator.
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
        
        //bitwise right operator.
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
        
        //modulo operator.
        addOperator(new Operator("%")
            .addEvaluator(
                Operator.EXPRESSION_ALL, 
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    return left.remainder(right);
                }   
            )
            .removeEvaluator(Operator.EXPRESSION_VECTOR_MATRIX)
        );
        
        //addition operator.
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
        
        //multiplication operator.
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
        
        //substraction operator
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
        
        //power operator.
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
        
        //division operator.
        addOperator(new Operator("/")
            .addEvaluator(
                Operator.EXPRESSION_ALL,
                (Evaluator<Type>) (Arithmetic left, Arithmetic right) -> {
                    return left.divide(right);
                }
            )
        );
        
        //logical OR operator.
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
        
        //logical AND operator.
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
        
        //less than operator.
        addOperator(new Operator("<")
            .addEvaluator(
                Operator.EXPRESSION_SYMMETRIC, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    return left.compareTo(right) == -1 ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .setDefaultEvaluator(def)
        );
        
        //greater than operator.
        addOperator(new Operator(">")
            .addEvaluator(
                Operator.EXPRESSION_SYMMETRIC, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    return left.compareTo(right) == 1 ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .setDefaultEvaluator(def)
        );
        
        //greater than or equal to operator.
        addOperator(new Operator(">=")
            .addEvaluator(
                Operator.EXPRESSION_SYMMETRIC, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    return left.compareTo(right) >= 1 ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .setDefaultEvaluator(def)
        );
        
        //less than or equal to operator.
        addOperator(new Operator("<=")
            .addEvaluator(
                Operator.EXPRESSION_SYMMETRIC, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    return left.compareTo(right) <= 1 ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .setDefaultEvaluator(def)
        );
        
        //logical equal to operator.
        addOperator(new Operator("==")
            .addEvaluator(
                Operator.EXPRESSION_SYMMETRIC, 
                (Evaluator<Scalar>) (Arithmetic left, Arithmetic right) -> {
                    return left.equals(right) ? Scalar.ONE : Scalar.ZERO;
                }   
            )
            .setDefaultEvaluator(def)
        );
        
        //logical not equal to operator.
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
    }
    
    /**
     * Adds a new function from a pre-defined handler.
     * @param name the name of the function
     * @param function the handler to apply when this function is called.
     * @return a reference to itself for method chaining.
     */
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
        return this.expression.toString();
    }
    
    /**
     * Sets the output listener to use when outputting evaluated statements.
     * @param listener the listener to use.
     * @return a reference to itself for method chaining.
     */
    public final Expression setOutputListener(OutputListener listener) {
        this.listener = listener;
        return this;
    }
    
    /**
     * Adds a new operator to use.
     * @param operator the operator to use
     * @return a reference to itself for method chaining.
     */
    public final Expression addOperator(Operator operator) {
        
        if(operator instanceof FixedOperator) {
            switch(((FixedOperator) operator).getFixPoint()) {
                case FixedOperator.POSTFIX:
                    this.postfixOperators.put(operator.getOper(), operator);
                    break;
                case FixedOperator.PREFIX:
                    this.prefixOperators.put(operator.getOper(), operator);
                    break;
            }
            return this;
        }
        
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
        this.addVariable(variableName, new Scalar(value));
        return this;
    }
    
    /**
     * Sets an expression to use.
     * @param expression the expression to use.
     * @return a reference to itself for method chaining.
     */
    public final Expression setExpression(String expression) {
        if(expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("invalid expression");
        }
        this.expression = new ANTLRInputStream(expression);
        return this;
    }
    
    /**
     * Sets an expression to use from a file.
     * @param source the expression source file to use.
     * @return a reference to itself for method chaining.
     */
    public final Expression setExpression(File source) {
        if(source == null || !source.exists() || source.isDirectory()) {
            if(source == null) {
                throw new IllegalArgumentException("invalid source location: location is null.");
            }
            throw new IllegalArgumentException("invalid source location: '" + source.getAbsolutePath()+ "'");
        }
        if(!this.validFileExtension(source)) {
            throw new RuntimeException("invalid file extension.");
        }
        try {
            this.expression = new ANTLRFileStream(source.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
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
     * Shows the generated Abstract Syntax Tree for the supplied expression.
     */
    public final void showAST() {
        
        Scope s = this.parse();
        
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        TreeViewer viewer = new TreeViewer(Arrays.asList(s.parser.getRuleNames()), s.tree);
        panel.setLayout(new BorderLayout());
        
        JScrollPane pane = new JScrollPane();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(panel);
        
        panel.add(pane);
        pane.getViewport().add(viewer);
        
        viewer.setScale(1.5);
        
        frame.setVisible(true);
        
    }
    
    /**
     * Attempts to parse the source expression.
     * @return The generated parse tree and parser instances.
     */
    private Scope parse() {
        if(this.expression == null) {
            throw new IllegalArgumentException("no valid expression was defined");
        }
        
        ExpressionLexer lexer = new ExpressionLexer(expression);
        ErrorHandler handler = new ErrorHandler(listener);
        lexer.removeErrorListeners();
        lexer.addErrorListener(handler);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(handler);
        Scope s = new Scope();
        s.parser = parser;
        s.tree = parser.start();
        s.lexer = lexer;
        s.handler = handler;
        s.functions = functions;
        s.listener = listener;
        s.operators = operators;
        s.postfixOperators = postfixOperators;
        s.prefixOperators = prefixOperators;
        s.variables = variables;
        s.expression = expression.toString();
        return s;
    }
    
    /**
     * Attempts to evaluate the expression.
     * @return the evaluated result to the defined MathContext's specification.
     * @throws RuntimeException if an error is reported by the error handler, i.e a syntax error etc.
     */
    public Context eval() throws RuntimeException {
        
        Scope s = this.parse();
        
        Visitor ve = new Visitor(s);
        Context c;
        try {
            c = ve.visit(s.tree);
        } catch (ExpressionException e) {
            c = e.getContext();
            if(listener != null) {
                listener.onReturn(c);
            }
        } catch (RuntimeException e) {
            //any other runtime exception is an error.
            if(listener == null) {
                throw e;
            }
            c = null;
            listener.exceptionThrown(e);
        }
        
        if(c == null) {
            //return an empty context.
            c = new Context(null, 1, 1, this.getExpression());
        }
        
        return c;
    }
    
    /**
     * Determines if the extension of a source file is valid.
     * @param source the source file.
     * @return TRUE if the extension of the file is valid, false otherwise.
     */
    private boolean validFileExtension(File source) {
        String extension = "";
        String fileName = source.getAbsolutePath();

        int i = fileName.lastIndexOf('.');
        int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

        if (i > p) {
            extension = fileName.substring(i+1);
        }
        return extension.equalsIgnoreCase("ex");
    }
    
}
