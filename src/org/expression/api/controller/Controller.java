package org.expression.api.controller;

import org.expression.api.DependencyInjector;

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
     * Initialises the controller, giving it easy access to the DI.
     * @param di the dependency injector.
     */
    public Controller(DependencyInjector di) {
        this.di = di;
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
    
}
