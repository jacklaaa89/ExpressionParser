package org.expression.api.controller;

import org.expression.api.DependencyInjector;
import org.expression.api.Dispatcher;
import org.expression.http.Request;

/**
 * Base Controller implementation.
 * @author Jack Timblin
 */
public abstract class Controller {
    
    /**
     * The dependency injector instance.
     */
    private final DependencyInjector di;
    
    /**
     * The current request object.
     */
    private final Request currentRequest;
    
    /**
     * The dispatcher dealing with the request.
     */
    private final Dispatcher dispatcher;
    
    /**
     * Initialises the controller, giving it easy access to the DI.
     * @param di the dependency injector.
     */
    public Controller(DependencyInjector di) {
        this.di = di;
        this.dispatcher = di.<Dispatcher>get("dispatcher");
        this.currentRequest = di.<Request>get("request");
    }
    
    /**
     * Gets a service from the DI.
     * @param <T> The object type of the service.
     * @param service the name of the service.
     * @return the service object, or null if no such service is defined.
     */
    public <T extends Object> T get(String service) {
        return this.di.<T>get(service);
    }
    
    public boolean has(String service) {
        return di.has(service);
    }
    
    /**
     * Gets the di instance. 
     * @return the dependency injector instance.
     */
    public DependencyInjector getDi() {
        return di;
    }
    
    /**
     * Gets the current request object.
     * @return the current request.
     */
    public Request getRequest() {
        return currentRequest;
    }
    
    /**
     * Gets the current dispatcher instance.
     * @return the current dispatcher.
     */
    public Dispatcher getDispatcher() {
        return dispatcher;
    }
    
}
