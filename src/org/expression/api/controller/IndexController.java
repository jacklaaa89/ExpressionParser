package org.expression.api.controller;

import org.expression.api.DependencyInjector;

/**
 *
 * @author Jack
 */
public class IndexController extends Controller {

    public IndexController(DependencyInjector di) {
        super(di);
    }
    
    public String indexAction() {
        return "This is a response";
    }
    
}
