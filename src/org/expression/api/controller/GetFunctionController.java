package org.expression.api.controller;

import org.expression.api.DependencyInjector;
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
    public String indexAction(String name) {
        return "The name is: " + name;
    }
    
}
