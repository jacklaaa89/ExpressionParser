package org.expression.api.controller;

import org.expression.Context;
import org.expression.Expression;
import org.expression.api.DependencyInjector;
import org.expression.api.annotation.HttpMethod;
import org.expression.api.exception.DispatchException;
import org.expression.http.RequestType;
import org.expression.http.StatusCode;
import org.expression.http.data.Data;

/**
 *
 * @author Jack
 */
public class EvaluateController extends Controller {

    public EvaluateController(DependencyInjector di) {
        super(di);
    }
    
    @HttpMethod({RequestType.POST})
    public Data indexAction() throws DispatchException {
        Data d = this.getRequest().getData();
        if(!d.hasKey("Expression")) {
            return new Data();
        }
        Expression e = new Expression();
        String ex = d.get("Expression", String.class);
        if(ex == null) {
            return new Data();
        }
        Data re = new Data();
        e.setExpression(ex);
        try {
            Context c = e.eval();
            re.set("Expression", c.getExpression());
            re.set("Result", c.getValue().toString());
            return re;
        } catch (RuntimeException er) {
            throw DispatchException.newInstance(
                    StatusCode.BAD_REQUEST, 
                    er.getMessage(), 
                    er
            );
        }
    }
}
