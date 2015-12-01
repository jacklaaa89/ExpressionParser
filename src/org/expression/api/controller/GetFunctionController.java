package org.expression.api.controller;

import java.util.List;
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
    public String indexAction(String name, List<String> params) {
        return name + ": " + params.toString();
    }
    
}
