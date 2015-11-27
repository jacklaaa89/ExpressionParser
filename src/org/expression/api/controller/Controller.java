package org.expression.api.controller;

import org.expression.api.DependencyInjector;

/**
 *
 * @author Jack
 */
public abstract class Controller {
    
    private final DependencyInjector di;
    
    public Controller(DependencyInjector di) {
        this.di = di;
    }
    
    public <T extends Object> T get(String service) {
        return this.di.<T>get(service);
    }
    
}
