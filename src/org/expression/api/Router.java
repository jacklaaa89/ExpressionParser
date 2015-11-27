package org.expression.api;

import java.util.HashMap;
import java.util.Map;
import org.expression.http.Request;

/**
 * The class which is responsible for maintaining and executing routes.
 * @author Jack Timblin
 */
public class Router {
    
    /**
     * The defined routes.
     */
    private final Map<String, Route> routes;
    
    /**
     * The route to use when nothing matches.
     */
    private Route notFoundRoute = null;
    
    /**
     * Whether to use the default routing strategy or not. 
     */
    private boolean useDefaultRouting = true;
    
    /**
     * The current request.
     */
    private Request currentRequest;
    
    /**
     * Initialises a router.
     * @param useDefault whether we use use the default routing strategy or not.
     */
    public Router(boolean useDefault) {
        routes = new HashMap<>();
        this.useDefaultRouting = useDefault;
        if(useDefaultRouting) {
            this.routes.put("/", new Route("/", "index", "index"));
            this.routes.put("/:controller(/?)", new Route("/:controller(/?)", "index"));
            this.routes.put("/:controller/:action(/:params)?", new Route("/:controller/:action(/:params)?"));
        }
    }
    
    /**
     * Initialises a router.
     * @param useDefault whether we use use the default routing strategy or not.
     * @param notFound the route to use if no other route matches the request.
     */
    public Router(boolean useDefault, Route notFound) {
        this(useDefault);
        this.notFoundRoute = notFound;
    }
    
    /**
     * Attempts to match the Request to a Route.
     * @param request the request to match.
     * @return a Route on a successful match or null if no match was found and
     * a notFound route is not defined.
     */
    public Route match(Request request) {
        //determine if we have a custom route.
        this.currentRequest = request;
        for(Map.Entry<String, Route> entry : routes.entrySet()) {
            Route route = entry.getValue();
            if(route.matches(request.getURI())) {
                return route;
            }
        }
        
        if(notFoundRoute != null) {
            return notFoundRoute;
        }
        
        return null;
    }
    
    /**
     * Gets the current request being processed by the Router.
     * @return the current request.
     */
    public Request getRequest() {
        return this.currentRequest;
    }
    
    @Override
    public String toString() {
        return this.routes.toString();
    }
    
}
