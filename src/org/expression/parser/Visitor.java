package org.expression.parser;

import org.expression.computation.Function;
import org.expression.computation.Operator;
import org.expression.structure.Matrix;
import org.expression.structure.Vector;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.expression.Context;
import org.expression.Scalar;
import org.expression.Type;
import org.expression.computation.Arithmetic;
import org.expression.output.ConsoleOutput;
import org.expression.output.OutputListener;
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
import org.expression.parser.ExpressionParser.AtomContext;
import org.expression.parser.ExpressionParser.AtomValueContext;
import org.expression.parser.ExpressionParser.ColumnContext;
import org.expression.parser.ExpressionParser.ElseStatementContext;
import org.expression.parser.ExpressionParser.ElseifStatementContext;
import org.expression.parser.ExpressionParser.ExpressionContext;
import org.expression.parser.ExpressionParser.ForLoopContext;
import org.expression.parser.ExpressionParser.ForcedLogicalOperationContext;
import org.expression.parser.ExpressionParser.IfStatementContext;
import org.expression.parser.ExpressionParser.IncDecExprContext;
import org.expression.parser.ExpressionParser.IncDecExpressionContext;
import org.expression.parser.ExpressionParser.LogicalOperationContext;
import org.expression.parser.ExpressionParser.MatrixContext;
import org.expression.parser.ExpressionParser.PrintContext;
import org.expression.parser.ExpressionParser.VariableContext;
import org.expression.parser.ExpressionParser.WhileLoopContext;

/**
 *
 * @author jacktimblin
 */
public class Visitor extends ExpressionBaseVisitor<Context> {
    
    private MathContext mc = MathContext.DECIMAL32;
    private final HashMap<String, Function> functions;
    private final HashMap<String, Operator> operators;
    private final HashMap<String, Type> variables;
    private OutputListener listener;
    
    public Visitor(HashMap<String, Function> functions, 
            HashMap<String, Operator> operators, 
            HashMap<String, Type> variables, OutputListener listener) {
        this.functions = functions;
        this.operators = operators;
        this.variables = variables;
        this.listener = listener;
    }
    
    public Visitor(HashMap<String, Function> functions, 
            HashMap<String, Operator> operators, 
            HashMap<String, Type> variables,
            MathContext mc, OutputListener listener) {
        this(functions, operators, variables, listener);
        this.mc = mc;
    }
    
    @Override
    public Context visitAssignment(AssignmentContext ctx) {
        boolean isUpdate = ctx.VAR() == null;
        String varName = ctx.variable(0).getText();
        if(isUpdate && !this.variables.containsKey(varName)) {
            throw new NullPointerException("can only update initialized variables.");
        }
        
        Context v = this.visit(ctx.expression());
        
        //determine if we are also attempting to update a value at a certain index.
        List<TerminalNode> i = ctx.DIGIT();
        
        int[] indices;
        
        if(i.isEmpty() && isUpdate && ctx.varIndex != null) {
            indices = new int[] { ((Scalar)this.parseValue(ctx.varIndex)).intValue() };
        } else {
            indices = this.convertNodeToInt(i);
        }
        
        Type t = this.variables.get(varName);
        
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
        
        this.variables.put(varName, v.getValue());
        return v;
    }
    
    /**
    * {@inheritDoc}
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
   @Override 
   public Context visitOpExpr(OpExprContext ctx) { 
       Context left = this.visit(ctx.left);
       Context right = this.visit(ctx.right);
       
       if(!this.operators.containsKey(ctx.op.getText())) {
           throw new ArithmeticException("undefined operator '"+ctx.op.getText()+"' found");
       }
       
       return this.operators.get(ctx.op.getText()).evaluate(left, right);
   }
   
   @Override
   public Context visitBoolExpr(BoolExprContext ctx) {
       Context left = this.visit(ctx.left);
       Context right = this.visit(ctx.right);
       
       if(!this.operators.containsKey(ctx.op.getText())) {
           throw new ArithmeticException("undefined operator '"+ctx.op.getText()+"' found");
       }
       
       return this.operators.get(ctx.op.getText()).evaluate(left, right);
   }
   
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
   
   @Override
   public Context visitVariable(VariableContext ctx) {
       return new Context(this.parseValue(ctx), ctx.start.getLine(), ctx.start.getCharPositionInLine(), this.getFullStatement(ctx));
   }
   
   @Override
   public Context visitForLoop(ForLoopContext ctx) {
       
       AssignmentContext ac = ctx.assignment();
       
       //visit the assignment to add the variable to the variables.
       this.visit(ac);
       String varName = ac.variable(0).getText();
       Type t = this.variables.get(varName);
       
       Context computed = this.visit(ctx.forcedLogicalOperation());
       
       while(computed.getValue().equals(Scalar.ONE)) {
           this.visit(ctx.start());
           t = (ctx.DECREMENT() != null) ? ((Arithmetic)t).decrement() : ((Arithmetic)t).increment();
           this.variables.put(varName, t);
           computed = this.visit(ctx.forcedLogicalOperation());
       }
       
       this.variables.remove(varName);
       return new Context(null, ctx.start.getLine(), ctx.start.getCharPositionInLine(), this.getFullStatement(ctx));
   }
   
   @Override
   public Context visitWhileLoop(WhileLoopContext ctx) {
       Context computed = this.visit(ctx.forcedLogicalOperation());
       
       while(computed.getValue().equals(Scalar.ONE)) {
           this.visit(ctx.start());
           computed = this.visit(ctx.forcedLogicalOperation());
       }
       return new Context(null, ctx.start.getLine(), ctx.start.getCharPositionInLine(), this.getFullStatement(ctx));
   }
   
   @Override
   public Context visitForcedLogicalOperation(ForcedLogicalOperationContext ctx) {
       boolean isFirst = ctx.variable().start.getCharPositionInLine() == ctx.start.getCharPositionInLine();
       Context left = (isFirst) ? this.visit(ctx.variable()) : this.visit(ctx.expr());
       Context right = (!isFirst) ? this.visit(ctx.variable()) : this.visit(ctx.expr());
       if(!this.operators.containsKey(ctx.LOGICAL().getText())) {
           throw new ArithmeticException("undefined operator '"+ctx.LOGICAL().getText()+"' found");
       }
       
       return this.operators.get(ctx.LOGICAL().getText()).evaluate(left, right);
   }
   
   @Override
   public Context visitLogicalOperation(LogicalOperationContext ctx) {
       Context left = this.visit(ctx.left);
       Context right = this.visit(ctx.right);
       
       if(!this.operators.containsKey(ctx.op.getText())) {
           throw new ArithmeticException("undefined operator '"+ctx.op.getText()+"' found");
       }
       
       return this.operators.get(ctx.op.getText()).evaluate(left, right);
   }
   
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
       List<TerminalNode> nodes = c.DIGIT();
       int[] indices;
       
       if(nodes.isEmpty()) {
           //we have a variable.
           Context va = this.visit(c.variable());
           indices = new int[] { ((Scalar)va.getValue()).intValue() };
       } else {
           indices = this.convertNodeToInt(nodes);
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
    * converts a list of terminal nodes which represent a DIGIT
    * into an array of their int representations.
    * @param nodes the list of terminal nodes.
    * @return an array of its int representations.
    */
   private int[] convertNodeToInt(List<TerminalNode> nodes) {
       int[] ints = new int[nodes.size()];
       for(int i = 0; i < nodes.size(); i++) {
           Integer in = Integer.parseInt(nodes.get(i).getText());
           ints[i] = in;
       }
       return ints;
   }
   
   @Override
   public Context visitIfStatement(IfStatementContext ctx) {
       Context e = new Context(null, ctx.start.getLine(), ctx.start.getCharPositionInLine(), this.getFullStatement(ctx));
       Context<Scalar> ifExpression = this.visit(ctx.logicalOperation());
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
           if(ctx.start() != null) {
                return this.visit(ctx.start());
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
               if(eif.start() != null) {
                    return this.visit(eif.start());
               }
               return e;
           }
       }
       ElseStatementContext elses = ctx.elseStatement();
       if(elses != null) {
           if(elses.start() != null) {
                return this.visit(elses.start());
           }
       }
       return e;
   }
   
   /**
    * {@inheritDoc}
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
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
           Vector v = new Vector(l.size(), mc);
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
                   Vector v = new Vector(ac.size(), mc);
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
           Vector ire = new Vector(end.expr().size(), mc);
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
           
           Matrix m = new Matrix(li, mc);
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
           return new Scalar(f, mc);
       } catch (NumberFormatException e) {
           //check that this is not a variablecontext.
           String varName = ctx.getText(); //default.
           boolean isMinus = false; //default.
           VariableContext c = (!(ctx instanceof VariableContext)) 
                   ? ((AtomValueContext)ctx).variable() : (VariableContext) ctx;
           if(c != null) {
               isMinus = c.MINUS() != null;
               varName = (isMinus) ? varName.substring(1, varName.length()) : varName;
           }
           //get the variable.   
           if(!this.variables.containsKey(varName)) {
               throw new ArithmeticException("variable '"+varName+"' is not defined.");
           }
           Type v = this.variables.get(varName);
           //negate this value if we have a minus.
           if(isMinus) {
               v = (Type) ((Arithmetic)v).negate();
           }
           return v;
       }
   }
   
   @Override
   public Context visitFuncDefinition(FuncDefinitionContext ctx) {
       //check to see that there is a function with that name, generate the params and 
       //return the result.
       String name = ctx.funcName().getText().toUpperCase(Locale.ROOT);
       Token s = ctx.start;
       String ex = this.getFullStatement(ctx);
       
       if(!this.functions.containsKey(name)) {
           throw new ArithmeticException("undefined function '"+name+"' called.");
       }
       
       Function f = this.functions.get(name);
       List<Type> args = new ArrayList<>();
       
        FuncParamsContext fp = ctx.funcParams();
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
        
        if(args.size() < f.getAmountOfExpectedParameters()) {
            throw new RuntimeException("invalid amount of parameters provided for function: " + f.getName());
        }
        
        try {
            return new Context(f.eval(args), s.getLine(), s.getCharPositionInLine(), ex);
        } catch(ClassCastException e) {
            throw new IllegalArgumentException("invalid parameter types provided for function: " + f.getName());
        }
   }
   
   @Override
   public Context visitPrint(PrintContext ctx) {
       Context c = this.visit(ctx.expression());
       if(listener == null) {
           listener = new ConsoleOutput();
       }
       listener.print(c);
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
    * {@inheritDoc}
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
   @Override 
   public Context visitParenExpr(ParenExprContext ctx) {
       return this.visit(ctx.expr()); 
   }
   
   @Override
   public Context visitExpression(ExpressionContext ctx) {
       return this.visit(ctx.expr());
   }
   
}
