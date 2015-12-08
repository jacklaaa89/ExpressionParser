package org.expression.api.controller;

import org.expression.Expression;
import org.expression.api.DependencyInjector;
import org.expression.api.annotation.IncludeParams;
import org.expression.api.annotation.Variable;
import org.expression.http.data.Data;

/**
 *
 * @author Jack
 */
public class GetExpressionController extends Controller {

    public GetExpressionController(DependencyInjector di) {
        super(di);
    }
    
    public Data indexAction() {
        Expression e = new Expression("1 + 1");
        Data d = new Data();
        d.set("expression", e.getExpression());
        return d;
    }
    
}
