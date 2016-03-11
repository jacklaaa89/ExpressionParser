package org.expression.parser;

import java.io.File;
import java.io.IOException;
import org.expression.computation.Function;
import org.expression.structure.Matrix;
import org.expression.structure.Vector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.expression.State;
import org.expression.Scalar;
import org.expression.Type;
import org.expression.computation.Arithmetic;
import org.expression.computation.Procedure;
import org.expression.output.ConsoleOutput;
import org.expression.parser.ExpressionParser.ArrayAccessContext;
import org.expression.parser.ExpressionParser.ArrayAccessExprContext;
import org.expression.parser.ExpressionParser.BoolExprContext;
import org.expression.parser.ExpressionParser.ExprContext;
import org.expression.parser.ExpressionParser.FuncDefinitionContext;
import org.expression.parser.ExpressionParser.FuncParamsContext;
import org.expression.parser.ExpressionParser.OpExprContext;
import org.expression.parser.ExpressionParser.ParenExprContext;
import org.expression.parser.ExpressionParser.ArrayContext;
import org.expression.parser.ExpressionParser.ArrayInnerContext;
import org.expression.parser.ExpressionParser.AssignmentContext;
import org.expression.parser.ExpressionParser.AtomValueContext;
import org.expression.parser.ExpressionParser.ColumnContext;
import org.expression.parser.ExpressionParser.ElseStatementContext;
import org.expression.parser.ExpressionParser.ElseifStatementContext;
import org.expression.parser.ExpressionParser.ExpressionContext;
import org.expression.parser.ExpressionParser.ForLoopContext;
import org.expression.parser.ExpressionParser.ForcedLogicalOperationContext;
import org.expression.parser.ExpressionParser.IfStatementContext;
import org.expression.parser.ExpressionParser.ImportStatementContext;
import org.expression.parser.ExpressionParser.IncDecExprContext;
import org.expression.parser.ExpressionParser.IncDecExpressionContext;
import org.expression.parser.ExpressionParser.IndexContext;
import org.expression.parser.ExpressionParser.InstanceOfExpressionContext;
import org.expression.parser.ExpressionParser.LogicalOperationContext;
import org.expression.parser.ExpressionParser.MatrixContext;
import org.expression.parser.ExpressionParser.NewExprContext;
import org.expression.parser.ExpressionParser.NewStructureContext;
import org.expression.parser.ExpressionParser.PrintContext;
import org.expression.parser.ExpressionParser.ProcedureContext;
import org.expression.parser.ExpressionParser.ProcedureReturnTypeContext;
import org.expression.parser.ExpressionParser.ReturnStatementContext;
import org.expression.parser.ExpressionParser.StartContext;
import org.expression.parser.ExpressionParser.TernaryContext;
import org.expression.parser.ExpressionParser.TernaryExprContext;
import org.expression.parser.ExpressionParser.TypeContext;
import org.expression.parser.ExpressionParser.VariableContext;
import org.expression.parser.ExpressionParser.WhileLoopContext;

/**
 * Visitor implementation used to evaluate parsed expressions.
 * @author Jack Timblin
 */
public class Visitor extends ExpressionBaseVisitor<Context> {
    /**
     * the current state of the expression variables.
     */
    private final State state;
    
    /**
     * Initializes a Visitor with all the required variables.
     * @param state the current state of the expression variables.
     */
    public Visitor(State state) {
        this.state = state;
    }
    
    /**
     * Triggers when a new structure statement is visited in the parse tree.
     * @param ctx the current context.
     * @return the evaluated result of the context.
     */
    @Override
    public Context visitNewExpr(NewExprContext ctx) {
        //generate a new vector/matrix with zero values from a certain length.
        //get the indices.
        NewStructureContext c = ctx.newStructure();
        
        //get the type.
        TypeContext ty = c.type();
        if(ty.SCALAR_TYPE() != null) {
            throw new IllegalArgumentException("Cannot construct a scalar as a type.");
        }
        
        //determine the index to access.
        List<IndexContext> in = c.index();

        int[] indices = new int[in.size()];
        for(int i = 0; i < in.size(); i++) {
            Context<Scalar> ce = this.visit(in.get(i));
            int v = ce.getValue().intValue();
            if(v == 0) {
                throw new RuntimeException("cannot initialize a new vector/matrix of zero length.");
            }
            indices[i] = v;
        }
        
        Type t; 
        
        if(ty.ARRAY_TYPE() != null) {
            t = Vector.zeroes(indices[0]);
        } else {
            if(indices.length == 1) {
                throw new RuntimeException("matrices need two dimension values.");
            }
            t = Matrix.zeroes(indices[0], indices[1]);
        }
        
        return new Context(t, c.start.getLine(), c.start.getCharPositionInLine(), this.getFullStatement(c));
        
    }
    
    /**
     * Triggers when a 'instanceof' statement is visited in the parse tree.
     * @param ctx the current context.
     * @return the evaluated result of the context.
     */
    @Override
    public Context visitInstanceOfExpression(InstanceOfExpressionContext ctx) {
        boolean negated = ctx.NOT() != null;
        TypeContext t = ctx.type();
        Class<?> type = (t.ARRAY_TYPE() != null) ? Vector.class : ((t.MATRIX_TYPE() != null) ? Matrix.class : Scalar.class);
        Context c = this.visit(ctx.variable());
        boolean is = (!negated) ? c.getValue().getClass().equals(type) : !c.getValue().getClass().equals(type);
        Scalar result = is ? Scalar.ONE : Scalar.ZERO;
        Token s = ctx.start;
        return new Context(result, s.getLine(), s.getCharPositionInLine(), this.getFullStatement(ctx));
    }
    
    /**
     * Triggers when a return statement is visited in the parse tree.
     * @param ctx the current context.
     * @return the evaluated result of the context.
     */
    @Override
    public Context visitReturnStatement(ReturnStatementContext ctx) {
        Context c = visit(ctx.expression());
        throw new ExpressionException(c);
    }
    
    /**
     * Triggers when a 'start' statement is visited in the parse tree.
     * @param ctx the current context.
     * @return the evaluated result of the context.
     */
    @Override
    public Context visitStart(StartContext ctx) {
        //run any import statements.
        List<ImportStatementContext> imports = ctx.importStatement();
        for(ImportStatementContext c : imports) {
            //get the file.
            //mutate the file name based on its structure.
            //if the name starts with a leading '/' it is an absolute location.
            //if the file has more than one entry ('/more/than/one') and the first entry is
            //a single letter then that is assumed to be a drive name if we are on windows.
            String fileName = c.file().getText();
            boolean isAbsolute = fileName.startsWith("/");
            String[] fne = (isAbsolute) ? fileName.substring(1).split("/") : fileName.split("/");
            boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
            if(fne.length > 1 && isWindows && fne[0].length() == 1) {
                fne[0] = fne[0].toUpperCase()+":";
                fileName = String.join("/", fne);
            }
            
            File f = new File(File.separator+fileName+".ex");
            if(!f.exists() || f.isDirectory()) {
                throw new RuntimeException("cannot located file import: " + f.getAbsolutePath());
            }
            try {
                ANTLRFileStream af = new ANTLRFileStream(f.getAbsolutePath());
                ExpressionLexer lexer = new ExpressionLexer(af);
                lexer.removeErrorListeners();
                lexer.addErrorListener(state.handler);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                ExpressionParser parser = new ExpressionParser(tokens);
                parser.removeErrorListeners();
                parser.addErrorListener(state.handler);
                Visitor v = new Visitor(state);
                v.visit(parser.start());
                
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        
        //run the context of this script.
        Context c = null;
        if(ctx.ex() != null) {
            c = visit(ctx.ex());
        }
        return c;
    }
    
    /**
     * Triggered when an assignment statement is visited in the parse tree.
     * Assigns the new variable and stores it in the variables list.
     * @param ctx the assignment context.
     * @return a context containing the new assigned value.
     */
    @Override
    public Context visitAssignment(AssignmentContext ctx) {
        boolean isUpdate = ctx.VAR() == null;
        String varName = ctx.variable().getText();
        if(isUpdate && !state.variables.containsKey(varName)) {
            throw new NullPointerException("can only update initialized variables.");
        }
        
        Context v = this.visit(ctx.expression());
        
        if(v == null || v.isEmptyContext()) {
            throw new RuntimeException("cannot assign null values as a variable.");
        }
        
        //determine the index to access.
        List<IndexContext> in = ctx.index();

        int[] indices = new int[in.size()];
        for(int i = 0; i < in.size(); i++) {
            Context<Scalar> ce = this.visit(in.get(i));
            indices[i] = ce.getValue().intValue();
        }
        
        Type t = state.variables.get(varName);
        
        if(indices.length > 0) {
            if(indices.length == 1 && t instanceof Vector) {
                //we are attempting to update a value in a vector.
                if(!v.isScalar()) {
                    throw new IllegalArgumentException("invalid type found.");
                }
                ((Vector)t).set(indices[0], (Scalar)v.getValue());
            } else if(indices.length >= 1) {
                if(!(t instanceof Matrix) || v.isMatrix()) {
                    throw new IllegalArgumentException("invalid type found.");
                }
                if(indices.length == 1) {
                    //adding a vector to a matrix.
                    if(!v.isArray()) {
                        throw new IllegalArgumentException("invalid type found.");
                    }
                    ((Matrix)t).set(indices[0], (Vector)v.getValue());
                } else {
                    //adding a scalar to a n,m point in a matrix.
                    if(!v.isScalar()) {
                        throw new IllegalArgumentException("invalid type found.");
                    }
                    ((Matrix)t).set(indices[0], indices[1], (Scalar)v.getValue());
                }
            } else {
                throw new IllegalArgumentException("invalid amount of indices defined.");
            }
            v = new Context(t, ctx.start.getLine(), ctx.start.getCharPositionInLine(), this.getFullStatement(ctx));
        }
        
        state.variables.put(varName, v.getValue());
        return v;
    }
    
    /**
     * Triggers when a 'ternary' statement is visited in the parse tree.
     * @param ctx the current context.
     * @return the evaluated result of the context.
     */
    @Override
    public Context visitTernaryExpr(TernaryExprContext ctx) {
        TernaryContext c = ctx.ternary();
        Context<Scalar> le = this.visit(c.logicalOperation());
        Scalar lev = le.getValue();
        boolean t = (lev.equals(Scalar.ONE));
        return (t) ? this.visit(c.expr(0)) : this.visit(c.expr(1));
    }
    
    /**
     * Triggered when an operator expression is visited in the parse tree.
     * @param ctx the operator expression context.
     * @return the context containing the evaluated operator expression result.
     */
   @Override 
   public Context visitOpExpr(OpExprContext ctx) { 
       Context left = this.visit(ctx.left);
       Context right = this.visit(ctx.right);
       
       if(!state.operators.containsKey(ctx.op.getText())) {
           throw new ArithmeticException("undefined operator '"+ctx.op.getText()+"' found");
       }
       
       return state.operators.get(ctx.op.getText()).evaluate(left, right);
   }
   
   /**
     * Triggered when an logical expression is visited in the parse tree.
     * @param ctx the logical expression context.
     * @return the context containing the evaluated logical expression result.
     */
   @Override
   public Context visitBoolExpr(BoolExprContext ctx) {
       Context left = this.visit(ctx.left);
       Context right = this.visit(ctx.right);
       
       if(!state.operators.containsKey(ctx.op.getText())) {
           throw new ArithmeticException("undefined operator '"+ctx.op.getText()+"' found");
       }
       
       return state.operators.get(ctx.op.getText()).evaluate(left, right);
   }
   
   /**
     * Triggered when an increment/decrement (++/--) expression is visited in the parse tree.
     * @param ctx the increment/decrement expression context.
     * @return the context containing the evaluated increment/decrement expression result.
     */
   @Override
   public Context visitIncDecExpr(IncDecExprContext ctx) {
       IncDecExpressionContext ce = ctx.incDecExpression();
       
       boolean isFunc = ce.func() != null;
       
       Context c;
       if(isFunc) {
           c = this.visit(ce.func());
       } else {
           c = this.visit(ce.atom());
       }
       
       Arithmetic t;
       t = (ce.DECREMENT() != null) ? ((Arithmetic)c.getValue()).decrement() : ((Arithmetic)c.getValue()).increment();
       return new Context(t, ctx.start.getLine(), ctx.start.getCharPositionInLine(), this.getFullStatement(ctx));
   }
   
   /**
    * Triggered when a variable is visited in the parse tree.
    * Attempts to parse the variable into its {@code Type} value.
    * @param ctx the variable context.
    * @return the evaluated Type value context.
    */
   @Override
   public Context visitVariable(VariableContext ctx) {
       return new Context(this.parseValue(ctx), ctx.start.getLine(), ctx.start.getCharPositionInLine(), this.getFullStatement(ctx));
   }
   
   /**
    * Triggered when a for loop is visited in the parse tree.
    * @param ctx the for loop context.
    * @return an Empty Context as all of the expressions are evaluated in the scope of
    * the loop.
    */
   @Override
   public Context visitForLoop(ForLoopContext ctx) {
       
       AssignmentContext ac = ctx.assignment();
       
       //visit the assignment to add the variable to the variables.
       this.visit(ac);
       String varName = ac.variable().getText();
       Type t = state.variables.get(varName);
       
       HashMap<String, Type> var = this.formatVariables(ctx);
       State s = State.from(state);
       s.variables = var;
       Visitor v = new Visitor(s);
       
       Context computed = v.visit(ctx.forcedLogicalOperation());
       
       while(computed.getValue().equals(Scalar.ONE)) {
           if(ctx.ex() != null) {
                try {
                    if(!ctx.ex().procedure().isEmpty()) {
                        throw new RuntimeException("cannot define a procedure in a control statement");
                    }
                    v.visit(ctx.ex());
                } catch (ExpressionException ex) {
                    throw ex;
                }
           }
           t = (ctx.DECREMENT() != null) ? ((Arithmetic)t).decrement() : ((Arithmetic)t).increment();
           var.put(varName, t);
           computed = v.visit(ctx.forcedLogicalOperation());
       }
       this.updateExisingValues(var);
       return new Context(null, ctx.start.getLine(), ctx.start.getCharPositionInLine(), this.getFullStatement(ctx));
   }
   
   /**
    * Triggered when a while loop is visited in the parse tree.
    * @param ctx the while loop context.
    * @return an Empty Context as all of the expressions are evaluated in the scope of
    * the loop.
    */
   @Override
   public Context visitWhileLoop(WhileLoopContext ctx) {
       HashMap<String, Type> var = this.formatVariables(ctx);
       State s = State.from(state);
       s.variables = var;
       Visitor v = new Visitor(s);
       Context computed = v.visit(ctx.forcedLogicalOperation());
       while(computed.getValue().equals(Scalar.ONE)) {
            try {
                if(!ctx.ex().procedure().isEmpty()) {
                    throw new RuntimeException("cannot define a procedure in a control statement");
                }
                v.visit(ctx.ex());
            } catch (ExpressionException ex) {
                throw ex;
            }
           computed = v.visit(ctx.forcedLogicalOperation());
       }
       this.updateExisingValues(var);
       return new Context(null, ctx.start.getLine(), ctx.start.getCharPositionInLine(), this.getFullStatement(ctx));
   }
   
   private void updateExisingValues(HashMap<String, Type> vars) {
       vars.entrySet().stream().filter((e) -> (state.variables.containsKey(e.getKey()))).forEach((e) -> {
           state.variables.put(e.getKey(), e.getValue());
        });
   }
   
   /**
    * Triggered when a forced logical operation is visited in the parse tree.
    * A forced logical operation is an logical expression that starts or ends with a variable.
    * @param ctx the forced logical operation context.
    * @return the Context of the evaluated result from this logical operation.
    */
   @Override
   public Context visitForcedLogicalOperation(ForcedLogicalOperationContext ctx) {
       if(ctx.instanceOfExpression() != null) {
           return this.visit(ctx.instanceOfExpression());
       }
       boolean isFirst = ctx.variable().start.getCharPositionInLine() == ctx.start.getCharPositionInLine();
       Context left = (isFirst) ? this.visit(ctx.variable()) : this.visit(ctx.expr());
       Context right = (!isFirst) ? this.visit(ctx.variable()) : this.visit(ctx.expr());
       if(!state.operators.containsKey(ctx.LOGICAL().getText())) {
           throw new ArithmeticException("undefined operator '"+ctx.LOGICAL().getText()+"' found");
       }
       
       return state.operators.get(ctx.LOGICAL().getText()).evaluate(left, right);
   }
   
   /**
    * Triggered when a logical operation is visited in the parse tree.
    * @param ctx the logical operation.
    * @return the evaluated logical operation.
    */
   @Override
   public Context visitLogicalOperation(LogicalOperationContext ctx) {
       if(ctx.instanceOfExpression() != null) {
           return this.visit(ctx.instanceOfExpression());
       }
       if(ctx.left == null) {
           return visitChildren(ctx);
       }
       Context left = this.visit(ctx.left);
       Context right = this.visit(ctx.right);
       
       if(!state.operators.containsKey(ctx.op.getText())) {
           throw new ArithmeticException("undefined operator '"+ctx.op.getText()+"' found");
       }
       
       return state.operators.get(ctx.op.getText()).evaluate(left, right);
   }
   
   @Override
   public Context visitIndex(IndexContext ctx) {
       Context v = new Context(this.parseValue(ctx), ctx.start.getLine(), ctx.start.getCharPositionInLine(), this.getFullStatement(ctx));
       if(!v.isScalar()) {
           throw new IllegalArgumentException("indices must be scalar");
       }
       return v;
   }
   
   /**
    * Triggered when array access is visited in the parse tree.
    * @param ctx the array access context.
    * @return the context of the value extracted from the array.
    */
   @Override
   public Context visitArrayAccessExpr(ArrayAccessExprContext ctx) {
       ArrayAccessContext c = ctx.arrayAccess();
       boolean isFuncCall = c.func() != null;
       Token t = c.start;
       String ex = this.getFullStatement(c);
      
       //evaluate the child and then attempt to access the result and return.
       Context con;
       if(isFuncCall) {
           con = this.visit(c.func());
       } else {
           con = this.visit(c.atom());
       }
       
       //cannot access a scalar as an array.
       if(con.isScalar()) {
           throw new IllegalArgumentException("cannot access scalar as an array.");
       }
       
       //determine the index to access.
       List<IndexContext> in = c.index();
       
       int[] indices = new int[in.size()];
       for(int i = 0; i < in.size(); i++) {
           Context<Scalar> ce = this.visit(in.get(i));
           indices[i] = ce.getValue().intValue();
       }
       
       Context res;
       if(con.isArray() && indices.length == 1) {
           //we have array access.
           res = new Context(((Vector)con.getValue()).get(indices[0]), t.getLine(), t.getCharPositionInLine(), ex);
       } else if(con.isMatrix() && indices.length >= 1) {
           //we have matrix access.
           if(indices.length == 1) {
               //return the vector row.
               res = new Context(((Matrix)con.getValue()).get(indices[0]), t.getLine(), t.getCharPositionInLine(), ex);
               return res;
           }
           res = new Context(((Matrix)con.getValue()).get(indices[0], indices[1]), t.getLine(), t.getCharPositionInLine(), ex);
       } else {
           //anything else is an error.
           throw new IllegalArgumentException("an error occured attempting to access array.");
       }
       
       return res;
       
   }
   
   /**
    * formats the variables to use in different scopes.
    * @param ctx the current context.
    * @return the formatted variables.
    */
   private HashMap<String, Type> formatVariables(ParserRuleContext ctx) {
       HashMap<String, Type> var = new HashMap<>();
       var.put("TRUE", state.variables.get("TRUE"));
       var.put("FALSE", state.variables.get("FALSE"));
       var.put("PI", state.variables.get("PI"));
       if(!(ctx instanceof FuncDefinitionContext)) {
           state.variables.entrySet().stream().filter((e) -> (!var.containsKey(e.getKey()))).forEach((e) -> {
               var.put(e.getKey(), e.getValue());
           });
       }
       return var;
   }
   
   /**
     * Triggers when a if/else statement is visited in the parse tree.
     * @param ctx the current context.
     * @return the evaluated result of the context.
     */
   @Override
   public Context visitIfStatement(IfStatementContext ctx) {
       Context e = new Context(null, ctx.start.getLine(), ctx.start.getCharPositionInLine(), this.getFullStatement(ctx));
       Context<Scalar> ifExpression = this.visit(ctx.logicalOperation());
       
       HashMap<String, Type> var = this.formatVariables(ctx);
       State s = State.from(state);
       s.variables = var;
       Visitor v = new Visitor(s);
       //it has to equate to boolean true or false (Scalar 1 or 0)
       if(ifExpression == null) {
           throw new IllegalArgumentException("if statement requires an expression to evaluate.");
       }
       if(!ifExpression.isScalar()) {
           throw new IllegalArgumentException("if statement expression must equate to boolean true or false");
       }
       Scalar b = ifExpression.getValue();
       if(b.equals(Scalar.ONE)) {
           //return the evaluated result from the if.
           if(ctx.ex() != null) {
                Context res;
                try {
                    if(!ctx.ex().procedure().isEmpty()) {
                        throw new RuntimeException("cannot define a procedure in a control statement");
                    }
                    res = v.visit(ctx.ex());
                    this.updateExisingValues(var);
                } catch (ExpressionException ex) {
                    throw ex;
                }
                return res;
           }
           return e;
       }
       //see if there is any elseif statements and return the first one which equates to true.
       List<ElseifStatementContext> eifs = ctx.elseifStatement();
       for(ElseifStatementContext eif : eifs) {
           Context<Scalar> elseif = this.visit(eif.logicalOperation());
           if(elseif == null) {
               throw new IllegalArgumentException("elseif statement requires an expression to evaluate.");
           }
           if(!elseif.isScalar()) {
              throw new IllegalArgumentException("elseif statement expression must equate to boolean true or false");
           }
           Scalar es = elseif.getValue();
           if(es.equals(Scalar.ONE)) {
               if(eif.ex() != null) {
                    Context res = null;
                    try {
                        if(!eif.ex().procedure().isEmpty()) {
                            throw new RuntimeException("cannot define a procedure in a control statement");
                        }
                        res = v.visit(eif.ex());
                        this.updateExisingValues(var);
                    } catch (ExpressionException ex) {
                        throw ex;
                    }
                    return res;
               }
               return e;
           }
       }
       ElseStatementContext elses = ctx.elseStatement();
       if(elses != null) {
           if(elses.ex() != null) {
                Context res = null;
                try {
                    if(!elses.ex().procedure().isEmpty()) {
                        throw new RuntimeException("cannot define a procedure in a control statement");
                    }
                    res = v.visit(elses.ex());
                    this.updateExisingValues(var);
                } catch (ExpressionException ex) {
                    throw ex;
                }
                return res;
           }
       }
       return e;
   }
   
   /**
     * Triggers when a 'procedure' statement is visited in the parse tree.
     * @param ctx the current context.
     * @return the evaluated result of the context.
     */
   @Override
   public Context visitProcedure(ProcedureContext ctx) {
       //this is a procedure declaration, assign as new function
       //throw an exception if the procedure already exists.
       String name = ctx.funcName().getText();
       if(state.procedures.containsKey(name.toUpperCase()) || state.functions.containsKey(name.toUpperCase())) {
           throw new RuntimeException("function '" + name.toUpperCase() + "' already defined.");
       }
       
       List<String> vn = new ArrayList<>();
       if(ctx.procedureParams() != null && !ctx.procedureParams().variable().isEmpty()) {
            List<VariableContext> l = ctx.procedureParams().variable();
            if(ctx.ex() != null) {
                if(!ctx.ex().procedure().isEmpty()) {
                    throw new RuntimeException("cannot define a function inside a function.");
                }
            }

            l.stream().forEach((ve) -> {
                vn.add(ve.getText());
           });
       }
       
       //determine if we have a return type specified for this procedure.
       ProcedureReturnTypeContext rt = ctx.procedureReturnType();
       Class<?> returnType = null;
       if(rt != null) {
            TypeContext t = rt.type();
            returnType = (t.ARRAY_TYPE() != null) ? Vector.class : ((t.MATRIX_TYPE() != null) ? Matrix.class : Scalar.class);
       }
       
       Procedure p = new Procedure(name, vn, ctx.ex(), returnType);
       state.procedures.put(name.toUpperCase(), p);
       return null;
   }
   
   /**
     * Triggers when a 'atomValue' statement is visited in the parse tree.
     * @param ctx the current context.
     * @return the evaluated result of the context.
     */
   @Override 
   public Context visitAtomValue(AtomValueContext ctx) {
       
       //determine if we have an array or not.
       boolean isArray  = (ctx.array() != null);
       boolean isMatrix = (ctx.matrix() != null); 
       String ex = this.getFullStatement(ctx);
       Token s = ctx.start;
       Context r;
       
       //arrays and matrices can have values evaluated from expr.
       if(isArray) {
           ArrayContext atx = ctx.array();
           boolean isMinus = atx.MINUS() != null;
           List<ExprContext> l = atx.expr();
           Vector v = new Vector(l.size());
           for(int i = 0; i < l.size(); i++) {
               ExprContext re = l.get(i);
               Context c = this.visit(re);
               if(!c.isScalar()) {
                   throw new RuntimeException("vectors can only accept scalar values.");
               }
               v.set(i, (Scalar)c.getValue());
           }
           if(isMinus) {
               v = (Vector) v.negate();
           }
           r = new Context(v, s.getLine(), s.getCharPositionInLine(), ex);
       } else if (isMatrix) {
           MatrixContext mtx = ctx.matrix();
           boolean isMinus = mtx.MINUS() != null;
           //if we have more than one column.
           List<ColumnContext> l = mtx.column();
           ArrayInnerContext end = mtx.arrayInner(); //always has.
           List<Vector> li = new ArrayList<>();
           if(!l.isEmpty()) {
               for(ColumnContext ct : l) {
                   List<ExprContext> ac = ct.arrayInner().expr();
                   Vector v = new Vector(ac.size());
                   for(int i = 0; i < ac.size(); i++) {
                       ExprContext ec = ac.get(i);
                       Context ecc = this.visit(ec);
                       if(!ecc.isScalar()) {
                           throw new RuntimeException("matrices can only accept scalar values.");
                       }
                       v.set(i, (Scalar) ecc.getValue());
                   }
                   li.add(v);
               }
           }
           Vector ire = new Vector(end.expr().size());
           for(int i = 0; i < end.expr().size(); i++) {
               ExprContext acx = end.expr().get(i);
               Context acxc = this.visit(acx);
               if(!acxc.isScalar()) {
                   throw new RuntimeException("matrices can only accept scalar values.");
               }
               Scalar d = (Scalar) acxc.getValue();
               ire.set(i, d);
           }
           li.add(ire);
           
           Matrix m = new Matrix(li);
           if(isMinus) {
               m = (Matrix) m.negate();
           }
           r = new Context(m, s.getLine(), s.getCharPositionInLine(), ex);
       } else {
            Type d = this.parseValue(ctx);
            r = new Context(d, s.getLine(), s.getCharPositionInLine(), ex);
       }
       return r;
   }
   
   /**
    * Attempts to parse a value from a context.
    * @param ctx the context to parse.
    * @return the parsed value.
    */
   private Type parseValue(ParserRuleContext ctx) {
       try{ 
           double f = Double.parseDouble(ctx.getText());
           return new Scalar(f);
       } catch (NumberFormatException e) {
           //check that this is not a variablecontext.
           String varName = ctx.getText(); //default.
           boolean isMinus = false; //default.
           
           VariableContext c = (!(ctx instanceof VariableContext))
                   ? ( (!(ctx instanceof AtomValueContext)) ? ((IndexContext)ctx).variable() : ((AtomValueContext)ctx).variable()) 
                   : (VariableContext) ctx;
           
           if(c != null) {
               isMinus = c.MINUS() != null;
               varName = (isMinus) ? varName.substring(1, varName.length()) : varName;
           }
           //get the variable.   
           if(!state.variables.containsKey(varName)) {
               throw new ArithmeticException("variable '"+varName+"' is not defined.");
           }
           Type v = state.variables.get(varName);
           //negate this value if we have a minus.
           if(isMinus) {
               v = (Type) ((Arithmetic)v).negate();
           }
           return v;
       }
   }
   
   /**
     * Triggers when a function definition statement is visited in the parse tree.
     * @param ctx the current context.
     * @return the evaluated result of the context.
     */
   @Override
   public Context visitFuncDefinition(FuncDefinitionContext ctx) {
       //check to see that there is a function with that name, generate the params and 
       //return the result.
       String name = ctx.funcName().getText().toUpperCase(Locale.ROOT);
       Token s = ctx.start;
       String ex = this.getFullStatement(ctx);
       
       FuncParamsContext fp = ctx.funcParams();
       List<Type> args = new ArrayList<>();
        if(fp != null) {
            List<ExprContext> expr = fp.expr();
            ParserRuleContext[] ab = new ParserRuleContext[(expr.size())];

            for(int i = 0; i < expr.size(); i++) {
                ab[(i)] = expr.get(i);
            }
            
            for(int i = 0; i < ab.length; i++) {
                 Context c = this.visit(ab[i]);
                 if(c == null) {
                     throw new NullPointerException("function parameters cannot be null.");
                 }
                 args.add(i, this.visit(ab[i]).getValue());
            }
             
        }
       
       //first check for a procedure.
       if(state.procedures.containsKey(name)) {
           //we have a procedure.
           Procedure p = state.procedures.get(name);
           if(args.size() != p.getVariableNames().size()) {
               throw new RuntimeException("invalid amount of parameters provided for function: " + p.getName());
           }
           HashMap<String, Type> sv = this.formatVariables(ctx);
           for(int i = 0; i < args.size(); i++) {
               sv.put(p.getVariableNames().get(i), args.get(i));
           }
           State se = State.from(state);
           se.variables = sv;
           return p.run(se);
       }
       
       if(!state.functions.containsKey(name)) {
           throw new ArithmeticException("undefined function '"+name+"' called.");
       }
       
       Function f = state.functions.get(name);
        
        if(args.size() < f.getAmountOfExpectedParameters()) {
            throw new RuntimeException("invalid amount of parameters provided for function: " + f.getName());
        }
        
        try {
            return new Context(f.eval(args), s.getLine(), s.getCharPositionInLine(), ex);
        } catch(ClassCastException e) {
            throw new IllegalArgumentException("invalid parameter types provided for function: " + f.getName());
        }
   }
   
   /**
     * Triggers when a 'print' statement is visited in the parse tree.
     * @param ctx the current context.
     * @return the evaluated result of the context.
     */
   @Override
   public Context visitPrint(PrintContext ctx) {
       Context c = this.visit(ctx.expression());
       if(state.listener == null) {
           state.listener = new ConsoleOutput();
       }
       state.listener.print(c);
       return c;
   }
   
   /**
    * Attempts to get the full statement from the parser, including whitespace.
    * @param ctx the context to get the full statement for.
    * @return the full statement.
    */
   private String getFullStatement(ParserRuleContext ctx) {
       if(ctx.start == null || ctx.stop == null || ctx.start.getStartIndex() < 0 || ctx.stop.getStopIndex() < 0) {
           return ctx.getText();
       }
       return ctx.start.getInputStream().getText(Interval.of(ctx.start.getStartIndex(), ctx.stop.getStopIndex()));
   }
   
   /**
     * Triggers when a statement is wrapped in parentheses is visited in the parse tree.
     * @param ctx the current context.
     * @return the evaluated result of the context.
     */
   @Override 
   public Context visitParenExpr(ParenExprContext ctx) {
       Context c = this.visit(ctx.expr()); 
       c.wrapExpression("(", ")");
       return c;
   }
   
   /**
     * Triggers when a statement is visited in the parse tree.
     * @param ctx the current context.
     * @return the evaluated result of the context.
     */
   @Override
   public Context visitExpression(ExpressionContext ctx) {
       return this.visit(ctx.expr());
   }
   
}
