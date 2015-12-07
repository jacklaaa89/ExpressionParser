package org.expression.api.controller;

import org.expression.api.DependencyInjector;
import org.expression.api.annotation.IncludeParams;
import org.expression.api.annotation.Variable;

/**
 *
 * @author Jack
 */
public class GetFunctionController extends Controller {

    public GetFunctionController(DependencyInjector di) {
        super(di);
    }
    
    @Variable(name="name",position=0)
    @IncludeParams
    public String indexAction() {
        if(getRequest().hasQuery("each")) {
            return (String) this.getRequest().getQuery("each");
        }
        return "no such query param";
    }
    
}
