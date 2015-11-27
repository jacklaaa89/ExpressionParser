/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.expression.api;

import java.util.HashMap;

/**
 *
 * @author Jack
 */
public class DependencyInjector {
    
    private final HashMap<String, Object> services;
    private static DependencyInjector DI;
    
    public DependencyInjector() {
        services = new HashMap<>();
    }
    
    public static final DependencyInjector getDefault() {
        if(!(DI instanceof DependencyInjector)) {
            DI = new DependencyInjector();
        }
        return DI;
    }
    
    public void set(String name, Service definition, boolean shared) {
        Object o = (shared) ? definition.definition() : definition;
        services.put(name, o);
    }
    
    public void set(String name, Service definition) {
        set(name, definition, false);
    }
    
    public void setShared(String name, Service definition) {
        set(name, definition, true);
    }
    
    public <T extends Object> T get(String name) {
        if(!services.containsKey(name)) {
            return null;
        }
        Object o = services.get(name);
        T t;
        try {
            if(o instanceof Service) {
                o = ((Service)o).definition();
            }

            t = (T) o;
            if(t instanceof InjectionAware) {
                ((InjectionAware)t).setDI(this);
            }
        } catch (ClassCastException e) {
            return null;
        }
        return t;
    }
    
}
