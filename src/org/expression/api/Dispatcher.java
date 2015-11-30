package org.expression.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.expression.api.annotation.HttpMethod;
import org.expression.api.annotation.IncludeParams;
import org.expression.api.annotation.Variable;
import org.expression.api.annotation.Variables;
import org.expression.api.controller.Controller;
import org.expression.http.Request;
import org.expression.http.Request.StatusCode;
import org.expression.http.RequestType;
import org.expression.http.Response;

/**
 *
 * @author Jack
 */
public class Dispatcher implements InjectionAware {
    
    private DependencyInjector di;
    
    /**
     * Handles actually dispatching the request to the controller/action.
     * @param request the request to dispatch.
     * @return the response.
     */
    public Response dispatch(Request request) {
        
        Router router = di.<Router>get("router");
        Route matched = router.match(request);
        
        if(matched == null) {
            throw new RuntimeException("Could not locate controller/action");
        }
        
        String controller = matched.getControllerName();
        
        try {
            Class<?> clz = Class.forName(controller);
            Constructor c = clz.getConstructor(new Class[]{ DependencyInjector.class });
            Object[] params = { di };
            Object o = c.newInstance(params);
            if(!(o instanceof Controller)) {
                throw new InstantiationException("not of <Controller> type.");
            }
            Method[] mz = clz.getDeclaredMethods();
            Method t = null;
            for(Method m : mz) {
                if(m.getName().equals(matched.getActionName())) {
                    t = m;
                    break;
                }
            }
            if(t == null) {
                throw new RuntimeException("Could not locate action");
            }
            
            if(t.getReturnType() != String.class && t.getReturnType() != Response.class) {
                throw new RuntimeException("invalid return type.");
            }
            
            //get annotations.
            Annotation[] an = t.getDeclaredAnnotationsByType(Variables.class);
            Variable[] v = t.getAnnotationsByType(Variable.class);
            v = (an.length > 0) ? ((Variables)an[0]).value() : v;
            Object[] mp = {};
            if(t.getParameterCount() > 0) { 
                //check to see if we have enough parameters.
                if(matched.getParams().size() < t.getParameterCount()) {
                    throw new RuntimeException("Not enough parameters.");
                }

                //check to see if the param names are set.
                Parameter[] pz = t.getParameters();
                if(v.length != pz.length || matched.getParams().size() < v.length) {
                    throw new RuntimeException("Not enough mapped Annotations");
                }
                Object[] paa = new Object[v.length];
                for(Variable va : v) {
                    if(!matched.getParams().containsKey(va.name())) {
                        throw new RuntimeException("no valid parameter");
                    }
                    Object ob = matched.getParams().get(va.name());
                    //check the type of the position.
                    if(pz.length <= va.position()) {
                        throw new RuntimeException("invalid parameter position.");
                    }
                    Parameter pp = pz[va.position()];
                    paa[va.position()] = ob;
                }
                mp = paa;
            }
            
            IncludeParams[] ip = t.getAnnotationsByType(IncludeParams.class);
            boolean includeParams = (ip.length > 0);
            
            if(includeParams) {
                List<String> par = new ArrayList<>();
                if(matched.getParams().containsKey("params")) {
                    par = (List<String>) matched.getParams().get("params");
                } 
                mp[mp.length - 1] = par;
            }
            
            //check that this method can handle this http method.
            HttpMethod[] httpMethods = t.getAnnotationsByType(HttpMethod.class);
            if(httpMethods.length > 0) {
                RequestType[] types = httpMethods[0].value();
                boolean accepted = false;
                for(RequestType type : types) {
                    if(type == request.getRequestType()) {
                        accepted = true;
                    }
                }
                if(!accepted) {
                    throw new RuntimeException("method cannot accept http method: " + request.getRequestType().toString());
                }
            }
            
            Object response = t.invoke(o, mp);
            Response res = (response instanceof Response) ? (Response) response : Response.buildResponse(StatusCode.OK, (String) response);
            return res;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | 
                IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Could not locate controller/action " + e.getMessage());
        } 
        
    }

    @Override
    public void setDI(DependencyInjector di) {
        this.di = di;
    }

    @Override
    public DependencyInjector getDI() {
        return this.di;
    }
    
}
