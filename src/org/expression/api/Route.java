package org.expression.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.expression.http.Request;
import org.expression.http.RequestType;

/**
 * A typical route, i.e a URI which can be translated to the Controller/Method to fire.
 * @author Jack Timblin
 */
public class Route {
    
    /**
     * The pattern to match against.
     */
    private Pattern pattern;
    
    /**
     * The string representation of the pattern to match against.
     */
    private String stringPattern;
    
    /**
     * The names of the parameter names defined in the pattern.
     */
    private List<String> groupNames;
    
    /**
     * The controller name, this can be defined with the route or pulled
     * from the pattern when the <code>:controller</code> placeholder is found
     * in the pattern.
     */
    private String controller;
    
    /**
     * The action name, this can be defined with the route or pulled
     * from the pattern when the <code>:action</code> placeholder is found
     * in the pattern.
     */
    private String action;
    
    /**
     * The original pattern with original place-holders etc, used in organizing routes.
     */
    private String mappedPattern;
    
    /**
     * The Http Method Request types that this route accepts.
     */
    private RequestType[] acceptedTypes = { RequestType.GET, RequestType.POST };
    
    /**
     * The parameters that were found in the matched route. This is either by custom
     * named placeholders in the form <code>{name:pattern}</code> or any params at the end of the route when
     * the <code>:params</code> placeholder is at the end.
     */
    private Map<String, Object> params;
    
    /**
     * The package where controllers are defined.
     */
    private final String CONTROLLER_PACKAGE = "org.expression.api.controller";
    
    /**
     * The amount of custom placeholders which are allowed in any one pattern.
     */
    private final int PARAMETER_LIMIT = 10; 
    
    /**
     * Initialises a Route with a pattern.
     * @param pattern The pattern to match with.
     */
    public Route(String pattern) {
        this.formatPlaceholders(pattern);
    }
    
    /**
     * Initialises a Route with a pattern.
     * @param pattern The pattern to match with.
     * @param acceptedTypes the accepted HTTP request types.
     */
    public Route(String pattern, RequestType[] acceptedTypes) {
        this(pattern);
        this.acceptedTypes = acceptedTypes;
    }
    
    /**
     * Formats the standard <code> :controller, :action, :params placeholders </code>
     * into usable regular expression groups.
     * @param pattern the pattern to format.
     */
    private void formatPlaceholders(String pattern) {
        
        if(pattern.endsWith("/")) {
            pattern = pattern.substring(0, pattern.length() - 1);
        }
        pattern += "(/)?";
        
        this.mappedPattern = pattern;
        
        if(!pattern.contains(":controller") && controller == null) {
            throw new RuntimeException("need a controller");
        }
        pattern = pattern.replace(":controller", "(?<controller>[a-zA-Z0-9\\_\\-]+)");
        List<String> t = new ArrayList<>();
        t.add("controller");
        if(pattern.contains(":action")) {
            pattern = pattern.replace(":action", "(?<action>[a-zA-Z0-9\\_\\-]+)");
            t.add("action");
        }
        if(pattern.contains(":params")) {
            if(pattern.contains("/:params")) {
                pattern = pattern.replace("/:params", ":params");
            }
            pattern = pattern.replace(":params", "(?<params>/(.*)*)");
            t.add("params");
        }
        this.stringPattern = pattern;
        this.groupNames = t;
        String patternRegex = "(\\{([A-Za-z0-9]+):([A-Za-z0-9\\-_\\+\\[\\]]+)\\})";
        Pattern p = Pattern.compile(patternRegex);
        
        Matcher m = p.matcher(stringPattern);
        int i = 0;
        while(m.find()) {
            if(i < PARAMETER_LIMIT) {
                String name = m.group(2);
                String pat = m.group(3);
                stringPattern = m.replaceFirst("(?<"+name+">"+pat+")");
                m = p.matcher(stringPattern);
                groupNames.add(name);
                i++;
            }
        }
        this.params = new HashMap<>();
        this.pattern = Pattern.compile(stringPattern);
    }
    
    /**
     * Initialises a pattern with a defined action.
     * @param pattern the pattern to match with.
     * @param routeDetails details of the controller and action.
     */
    public Route(String pattern, String...routeDetails) {
        if(routeDetails.length > 0) {
            controller = routeDetails[0];
            if(routeDetails.length > 1) {
                action = routeDetails[1];
            }
        }
        this.formatPlaceholders(pattern);
    }
    
    /**
     * Initialises a pattern with a defined action.
     * @param pattern the pattern to match with.
     * @param acceptedTypes the HTTP methods this route accepts.
     * @param routeDetails details of the controller and action.
     */
    public Route(String pattern, RequestType[] acceptedTypes, String... routeDetails) {
        this(pattern, routeDetails);
        this.acceptedTypes = acceptedTypes;
    }
    
    /**
     * Determines whether a URI matches this route.
     * @param request the request to match with.
     * @return <code>TRUE</code> if this route matches the URI, <code>FALSE</code> otherwise.
     */
    public boolean matches(Request request) {
        
        Matcher m = pattern.matcher(request.getURI());
        if(!m.matches()) {
            return false;
        }
        
        if(!Arrays.asList(acceptedTypes).contains(request.getRequestType())) {
            return false; //route doesnt match request type.
        }
        
        if(groupNames.contains("controller") && controller == null) {
            controller = m.group("controller");
        }
        if(groupNames.contains("action") && action == null) {
            action = m.group("action");
        }
        if(groupNames.contains("params")) {
            String p = m.group("params");
            if(p != null) {
                String[] e = p.trim().split("/");
                String[] d = new String[e.length-1];
                System.arraycopy(e, 1, d, 0, d.length);
                List<String> pe = new ArrayList<>();
                for(int i = 0; i < d.length; i++) {
                    pe.add(d[i]);
                }
                params.put("params", pe);
            }
        }
        groupNames.remove("action");
        groupNames.remove("params");
        groupNames.remove("controller");
        
        for(String entry : groupNames) {
            params.put(entry, m.group(entry));
        }
        
        return true;
    }
    
    /**
     * Gets the params defined in the URI. Should only be called after matching.
     * @return the matches params.
     */
    public Map<String, Object> getParams() {
        return this.params;
    }
    
    /**
     * Determines the fully qualified controller class name to use.
     * This method doesn't check if the class exists.
     * @return The fully qualified controller name.
     */
    public String getControllerName() {
        if(controller == null) {
            throw new RuntimeException("Controller is not defined.");
        }
        String stripped = controller.replaceAll("[^A-Za-z0-9\\-]", "");
        
        //format the spaces to camelCase.
        String[] spl = stripped.split("\\-");
        StringBuilder b = new StringBuilder();
        for(String s : spl) {
            b.append(s.substring(0, 1).toUpperCase());
            b.append(s.substring(1, s.length()).toLowerCase());
        }
        
        stripped = b.toString();
        String controllerName = stripped + "Controller";
        return CONTROLLER_PACKAGE + "." + controllerName;
    }
    
    /**
     * returns the original pattern which declared this route.
     * @return the original pattern.
     */
    public String getPattern() {
        return this.mappedPattern;
    }
    
    /**
     * Determines the controller method name to execute.
     * This method doesn't check if the method exists.
     * @return The method name.
     */
    public String getActionName() {
        if(action == null) {
            throw new RuntimeException("Action is not defined.");
        }
        String stripped = action.replaceAll("[^A-Za-z0-9\\-]", "");
        //format the spaces to camelCase.
        String[] spl = stripped.split("\\-");
        StringBuilder b = new StringBuilder();
        for(String s : spl) {
            b.append(s.substring(0, 1).toUpperCase());
            b.append(s.substring(1, s.length()).toLowerCase());
        }
        stripped = b.toString();
        stripped = stripped.substring(0, 1).toLowerCase() + stripped.substring(1, stripped.length());
        
        String actionName = stripped + "Action";
        return actionName;
    }
    
    @Override
    public String toString() {
        return stringPattern;
    }
    
}
