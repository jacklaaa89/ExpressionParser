package org.expression.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.expression.api.controller.Controller;
import org.expression.http.Request;
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
     */
    public void dispatch(Request request) {
        
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
            
            Object[] mp = {};
            if(t.getParameterCount() > 0) { 
                //check to see if we have enough parameters.
                if(matched.getParams().size() < t.getParameterCount()) {
                    throw new RuntimeException("Not enough parameters.");
                }

                //check to see if the param names are set.
                Parameter[] pz = t.getParameters();
                Map<String, Object> matchedParams = matched.getParams();
                List<Object> ep = new ArrayList<>();
                for(Parameter en : pz) {
                    if(!matchedParams.containsKey(en.getName())) {
                        //we dont have this parameter.
                        throw new RuntimeException("invalid parameter.");
                    }
                    Object e = matchedParams.get(en.getName());
                    if(e.getClass() != en.getType()) {
                        throw new RuntimeException("invalid parameter type.");
                    }
                    ep.add(e);
                }
                mp = ep.toArray(new Object[]{});
            }
            
            Object response = t.invoke(o, mp);
            System.out.println(response);
            
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | 
                IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Could not locate controller/action");
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
