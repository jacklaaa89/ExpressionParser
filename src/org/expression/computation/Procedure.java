package org.expression.computation;

import java.util.List;
import org.antlr.v4.runtime.ParserRuleContext;
import org.expression.parser.Context;
import org.expression.Scope;
import org.expression.parser.ExpressionException;
import org.expression.parser.Visitor;

/**
 * An encapsulation of a single procedure. This is effectively a function which 
 * has been defined in the script. The final expression in this procedures context
 * will be the return value.
 * @author Jack Timblin
 */
public class Procedure {
    
    /**
     * The names of the variables for this procedure.
     * These are critical as to match to variables declared/used in the context.
     */
    private final List<String> variableNames;
    
    /**
     * The context of this procedure. I.e the body of the function.
     */
    private final ParserRuleContext ctx;
    
    /**
     * The name of the procedure.
     */
    private final String name;
    
    /**
     * The return type of the procedure, can be nullified.
     */
    private Class<?> returnType = null;
    
    /**
     * Initializes A new procedure to use within the script.
     * @param name the name of the procedure.
     * @param variableNames the names of the variables that were defined.
     * @param ctx the scope/context/body of the procedure.
     * @param returnType any applied return type of this procedure.
     */
    public Procedure(
            String name, 
            List<String> variableNames, 
            ParserRuleContext ctx, 
            Class<?> returnType
    ) {
        this.variableNames = variableNames;
        this.name = name;
        this.ctx = ctx;
        this.returnType = returnType;
    }
    
    /**
     * Run this procedure using a provided visitor.
     * @param state the provided visitor
     * @return the context from running this procedures context/body.
     */
    public Context run(final Scope state) {
        Visitor v = new Visitor(state);
        Context res;
        if(ctx == null) {
            //generate a empty context from the state if there is 
            //no body to this procedure.
            return new Context(null, 1, 1, state.expression);
        }
        try {
            res = v.visit(ctx);
        } catch (ExpressionException ex) {
            res = ex.getContext();
        }
        
        if(returnType != null) {
            if(!res.getValue().getClass().equals(returnType)) {
                throw new RuntimeException("Invalid return type found. Expected: " + returnType.getSimpleName() + ", Found: " + res.getValue().getClass().getSimpleName());
            }
        }
        
        return res;
    }
    
    /**
     * gets the names of the defined variables in this procedure.
     * @return the list of variable names.
     */
    public List<String> getVariableNames() {
        return variableNames;
    }
    
    /**
     * gets the body/context of this procedure.
     * @return this procedures context/body.
     */
    public ParserRuleContext getCtx() {
        return ctx;
    }
    
    /**
     * gets the name of this procedure.
     * @return this procedures declared name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * gets this procedures return type. Will be null if there was no return type defined.
     * @return this procedures return type.
     */
    public Class<?> getReturnType() {
        return this.returnType;
    }
    
}
