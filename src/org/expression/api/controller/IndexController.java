package org.expression.api.controller;

import java.util.List;
import org.expression.api.DependencyInjector;
import org.expression.api.annotation.HttpMethod;
import org.expression.api.annotation.IncludeParams;
import org.expression.api.annotation.Variable;
import org.expression.http.RequestType;

/**
 *
 * @author Jack
 */
public class IndexController extends Controller {

    public IndexController(DependencyInjector di) {
        super(di);
    }
    
    @IncludeParams
    public String indexAction(List<String> params) {
        return "This is a response: " + params.toString(); 
    }
    
}
