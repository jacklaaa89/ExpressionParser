package org.expression.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import org.expression.api.annotation.HttpMethod;
import org.expression.api.annotation.IncludeParams;
import org.expression.api.annotation.Variable;
import org.expression.api.annotation.Variables;
import org.expression.api.controller.Controller;
import org.expression.api.exception.DispatchException;
import org.expression.http.Request;
import org.expression.http.RequestType;
import org.expression.http.Response;
import org.expression.http.StatusCode;

/**
 * Class which actively dispatches a request received from a client.
 * @author Jack Timblin
 */
public class Dispatcher implements InjectionAware, EventAware {
    
    /**
     * The DI instance.
     */
    private DependencyInjector di;
    
    /**
     * The current request being dispatched.
     */
    private Request currentRequest;
    
    /**
     * An attached event manager.
     */
    private EventManager manager;
    
    /**
     * Handles actually dispatching the request to the controller/action.
     * @param request the request to dispatch.
     * @return the response.
     */
    public Response dispatch(Request request) throws DispatchException {
        currentRequest = request;
        
        try {
            manager.fire("dispatch:beforeDispatch", this, null, true);
        } catch (DispatchException e) {
            throw e;
        }
        
        Router router = di.<Router>get("router");
        Route matched = router.match(request);
                
        if(matched == null) {
            DispatchException ex = new DispatchException(StatusCode.NOT_FOUND, "<Could not locate controller/action>", null);
            manager.fire("dispatch:beforeNotFound", this, ex, true);
            if(manager.isCollectingResponses()) {
                ArrayList<Object> responses = manager.getResponses();
                for(Object entry : responses) {
                    if(entry instanceof Response) {
                        return (Response) entry;
                    }
                }
            }
            throw ex;
        }
        
        String controller = matched.getControllerName();
        
        try {
            Class<?> clz = Class.forName(controller);
            Constructor c = clz.getConstructor(new Class[]{ DependencyInjector.class });
            Object[] params = { di };
            Object o = c.newInstance(params);
            if(!(o instanceof Controller)) {
                throw new DispatchException(StatusCode.INTERNAL_SERVER_ERROR, "<Internal Server Error>", null);
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
                throw new DispatchException(StatusCode.NOT_FOUND, "<Could not locate action>", null);
            }
            
            if(t.getReturnType() != String.class && t.getReturnType() != Response.class) {
                throw new DispatchException(StatusCode.INTERNAL_SERVER_ERROR, "<Internal Server Error>", null);
            }
            
            //get annotations.
            Annotation[] an = t.getDeclaredAnnotationsByType(Variables.class);
            Variable[] v = t.getAnnotationsByType(Variable.class);
            v = (an.length > 0) ? ((Variables)an[0]).value() : v;
            Object[] mp = new Object[t.getParameterCount()];
            
            IncludeParams[] ip = t.getAnnotationsByType(IncludeParams.class);
            boolean includeParams = (ip.length > 0);
            
            if(includeParams) {
                List<String> par = new ArrayList<>();
                if(matched.getParams().containsKey("params")) {
                    par = (List<String>) matched.getParams().get("params");
                } 
                mp[mp.length - 1] = par;
            }
            
            //check the remainder of the Parameters.
            if(v.length + ((includeParams) ? 1 : 0) != t.getParameterCount()) {
                throw new DispatchException(
                    StatusCode.INTERNAL_SERVER_ERROR,
                    "<Internal Server Error>",
                    new RuntimeException("Not enough declared parameters")
                );
            }
            
            if(v.length > matched.getParams().size()) { //params is provided regardless.
                throw new DispatchException(
                    StatusCode.INTERNAL_SERVER_ERROR,
                    "<Internal Server Error>",
                    new RuntimeException("Not enough provided parameters")
                );
            }
            
            //get params.
            Parameter[] pz = t.getParameters();
            for(Variable va : v) {
                if(!matched.getParams().containsKey(va.name())) {
                    throw new DispatchException(
                        StatusCode.INTERNAL_SERVER_ERROR,
                        "<Internal Server Error>",
                        new RuntimeException("Required Parameter not provided.")
                    );
                }
                Object ob = matched.getParams().get(va.name());
                if(va.position() >= pz.length || va.position() < 0) {
                    throw new DispatchException(
                        StatusCode.INTERNAL_SERVER_ERROR,
                        "<Internal Server Error>",
                        new RuntimeException("Provided position index is out of bounds")
                    );
                }
                Parameter pp = pz[va.position()];
                if(pp.getType() != ob.getClass()) {
                    throw new DispatchException(
                        StatusCode.INTERNAL_SERVER_ERROR,
                        "<Internal Server Error>",
                        new RuntimeException("Provided Object is of invalid type.")
                    );
                }
                if(mp[va.position()] != null) {
                    throw new DispatchException(
                        StatusCode.INTERNAL_SERVER_ERROR,
                        "<Internal Server Error>",
                        new RuntimeException("Duplicate parameter position defined")
                    );
                }
                mp[va.position()] = ob;
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
                    throw new DispatchException(StatusCode.INTERNAL_SERVER_ERROR, "<method cannot accept http method: " + request.getRequestType().toString() + ">", null);
                }
            }
            
            Object response = t.invoke(o, mp);
            Response res = (response instanceof Response) ? (Response) response : Response.buildResponse(StatusCode.OK, null, (String) response);
            
            try {
                manager.fire("dispatch:afterDispatch", this, null, true);
            } catch (DispatchException e) {
                throw e;
            }
            
            return res;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new DispatchException(StatusCode.NOT_FOUND, "<Could not locate action>", e);
        } catch (ClassNotFoundException | NoSuchMethodException ex) {
            DispatchException dex = new DispatchException(StatusCode.NOT_FOUND, "<Could not locate controller/action>", ex);
            manager.fire("dispatch:beforeNotFound", this, dex, true);
            if(manager.isCollectingResponses()) {
                ArrayList<Object> responses = manager.getResponses();
                for(Object entry : responses) {
                    if(entry instanceof Response) {
                        return (Response) entry;
                    }
                }
            }
            throw dex;
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
    
    /**
     * Get the current request being dispatched.
     * @return the current request being dispatched, this will be null if
     * no request has yet been dispatched by this dispatcher, or the previous request between
     * dispatch calls.
     */
    public Request getCurrentRequest() {
        return this.currentRequest;
    }

    @Override
    public void setEventManager(EventManager manager) {
        this.manager = manager;
    }

    @Override
    public EventManager getEventManager() {
        return this.manager;
    }
    
}
