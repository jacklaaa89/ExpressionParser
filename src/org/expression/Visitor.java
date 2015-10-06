package org.expression;

import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.antlr.v4.runtime.ParserRuleContext;
import org.expression.parser.ExpressionBaseVisitor;
import org.expression.parser.ExpressionParser.BoolExprContext;
import org.expression.parser.ExpressionParser.ExprContext;
import org.expression.parser.ExpressionParser.FuncDefinitionContext;
import org.expression.parser.ExpressionParser.FuncParamsContext;
import org.expression.parser.ExpressionParser.OpExprContext;
import org.expression.parser.ExpressionParser.ParenExprContext;
import org.expression.parser.ExpressionParser.ArrayContext;
import org.expression.parser.ExpressionParser.ArrayInnerContext;
import org.expression.parser.ExpressionParser.AtomContext;
import org.expression.parser.ExpressionParser.AtomValueContext;
import org.expression.parser.ExpressionParser.ColumnContext;
import org.expression.parser.ExpressionParser.MatrixContext;

/**
 *
 * @author jacktimblin
 */
public class Visitor extends ExpressionBaseVisitor<Context> {
    
    private MathContext mc = MathContext.DECIMAL32;
    private final HashMap<String, Function> functions;
    private final HashMap<String, Operator> operators;
    private final HashMap<String, Type> variables;
    
    public Visitor(HashMap<String, Function> functions, 
            HashMap<String, Operator> operators, 
            HashMap<String, Type> variables) {
        this.functions = functions;
        this.operators = operators;
        this.variables = variables;
    }
    
    public Visitor(HashMap<String, Function> functions, 
            HashMap<String, Operator> operators, 
            HashMap<String, Type> variables,
            MathContext mc) {
        this(functions, operators, variables);
        this.mc = mc;
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
       Context r;
       
       //arrays and matrices can have values evaluated from expr.
       if(isArray) {
           ArrayContext atx = ctx.array();
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
           r = new Context(v);
       } else if (isMatrix) {
           MatrixContext mtx = ctx.matrix();
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
           r = new Context(m);
       } else {
            Type d = this.parseValue(ctx);
            r = new Context(d);
       }
       return r;
   }
   
   private Type parseValue(ParserRuleContext ctx) {
       try{ 
           double f = Double.parseDouble(ctx.getText());
           return new Scalar(f, mc);
       } catch (NumberFormatException e) {
           //get the variable.   
           if(!this.variables.containsKey(ctx.getText())) {
               throw new ArithmeticException("variable '"+ctx.getText()+"' is not defined.");
           }
           Type v = this.variables.get(ctx.getText());
           return v;
       }
   }
   
   @Override
   public Context visitFuncDefinition(FuncDefinitionContext ctx) {
       //check to see that there is a function with that name, generate the params and 
       //return the result.
       String name = ctx.funcName().getText().toUpperCase(Locale.ROOT);
       
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
            throw new RuntimeException("invalid amount of parameters");
        }
       
       return new Context(f.eval(args));
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
   
}
