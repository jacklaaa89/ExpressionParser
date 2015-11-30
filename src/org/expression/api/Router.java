package org.expression.api;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.expression.api.annotation.HttpMethod;
import org.expression.api.annotation.IncludeParams;
import org.expression.api.annotation.Variable;
import org.expression.api.annotation.Variables;
import org.expression.api.controller.Controller;
import org.expression.http.Request;
import org.expression.http.RequestType;

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
            this.buildRoutesFromControllers();
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
            if(route.matches(request)) {
                return route;
            }
        }
        
        if(notFoundRoute != null) {
            return notFoundRoute;
        }
        
        return null;
    }
    
    /**
     * Maps a route in this router.
     * @param route the route to map.
     */
    public void map(Route route) {
        this.routes.put(route.getPattern(), route);
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
    
    /**
     * Builds routes from controllers .
     */
    private void buildRoutesFromControllers() {
        String defaultPackage = "org.expression.api.controller";
        try {
            ArrayList<Class<?>> clzs = ReflectionHelper.getClassesForPackage(defaultPackage);
            
            //Only get the classes that extend the Controller class.
            for(Class<?> clz : clzs) {
                try {
                    Class<?> casted = clz.asSubclass(Controller.class);
                    if(casted.getSimpleName().equals("Controller") && Modifier.isAbstract(casted.getModifiers())) {
                        clzs.remove(clz); //remove the base abstract Controller class.
                    }
                } catch (ClassCastException e) {
                    clzs.remove(clz);
                }
            }
            
            for(Class<?> cl : clzs) {
                //go through and get the action methods (which are defined as routes.) 
                int index = cl.getSimpleName().indexOf("Controller");
                String controller = cl.getSimpleName().substring(0, index).replaceAll("([A-Z][a-z\\d]+)(?=([A-Z][a-z\\d]+))", "$1-").toLowerCase();
                Method[] methods = cl.getDeclaredMethods();
                for(Method m : methods) {
                    if(m.getName().endsWith("Action")) {
                        //construct the route pattern.
                        //get the Accepted http methods.
                        HttpMethod[] httpMethods = m.getAnnotationsByType(HttpMethod.class);
                        RequestType[] types = (httpMethods.length > 0) ? httpMethods[0].value() : new RequestType[] { RequestType.GET, RequestType.POST };
                        
                        //get the variables for the action.
                        Variables[] variable = m.getAnnotationsByType(Variables.class);
                        Variable[] variables = m.getAnnotationsByType(Variable.class);
                        variables = (variable.length > 0) ? variable[0].value() : variables;
                        
                        //get the action name.
                        int actionIndex = m.getName().indexOf("Action");
                        String action = m.getName().substring(0, actionIndex).replaceAll("([A-Z][a-z\\d]+)(?=([A-Z][a-z\\d]+))", "$1-").toLowerCase();
                        
                        //generate the start of the pattern.
                        String pattern = "/" + controller 
                                +
                                (
                                (variables.length > 0)
                                ? "/" + action   
                                : ((action.equals("index")) ? "(/" : "/") + action + ((action.equals("index")) ? ")?" : ""));
                        
                        //add the variables.
                        for(Variable v : variables) {
                            if(!v.name().equals("params")) {
                                String iPattern = "{arg_" + v.position() + ":[A-Za-z0-9-_]+}";
                                pattern += "/" + iPattern;
                            }
                        }
                        
                        for(Variable v : variables) {
                            pattern = pattern.replaceFirst("arg_" + v.position(), v.name());
                        }
                        
                        IncludeParams[] include = m.getAnnotationsByType(IncludeParams.class);
                        boolean containsParams = include.length > 0;
                        
                        pattern += (containsParams) ? "(/:params)?" : "(/)?";
                        this.map(new Route(pattern, controller, action, types));
                    }
                }
            }
            
        } catch(ClassNotFoundException e) {}
    }
    
    public Map<String, Route> getRoutes() {
        return this.routes;
    }
    
}
