package org.expression.computation;

import java.util.List;
import org.antlr.v4.runtime.ParserRuleContext;
import org.expression.Context;
import org.expression.State;
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
    private final String name;
    
    public Procedure(String name, List<String> variableNames, ParserRuleContext ctx) {
        this.variableNames = variableNames;
        this.name = name;
        this.ctx = ctx;
    }
    
    public Context run(final Visitor scope) {
        Context res;
        try {
            res = scope.visit(ctx);
        } catch (ExpressionException ex) {
            res = ex.getContext();
        }
        return res;
    }
    
    public List<String> getVariableNames() {
        return variableNames;
    }

    public ParserRuleContext getCtx() {
        return ctx;
    }

    public String getName() {
        return name;
    }
    
}
