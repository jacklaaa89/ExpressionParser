package org.expression.api;

import java.util.HashMap;

/**
 * Service injector which allows for components in the framework to be easily accessible
 * throughout the application.
 * @author Jack Timblin
*/
public class DependencyInjector {
    
    /**
     * The container for all the services which we can store by name.
     */
    private final HashMap<String, Object> services;
    
    /**
     * A static global accessible instance of the DependencyInjector.
     */
    private static DependencyInjector DI;
    
    /**
     * Initialises the DI, setting a default EventManager.
     */
    private DependencyInjector() {
        services = new HashMap<>();
        set("eventManager", new EventManager(), true);
    }
    
    /**
     * Access point to this applications DI.
     * @return this applications DI.
     */
    public static final DependencyInjector getDefault() {
        if(!(DI instanceof DependencyInjector)) {
            DI = new DependencyInjector();
        }
        return DI;
    }
    
    /**
     * Sets a service to be managed by the DI.
     * @param name the name of the service.
     * @param definition the service definition.
     * @param shared  whether the same instance should be used or a new instance on each
     * retrieval.
     */
    public final void set(String name, Service definition, boolean shared) {
        Object o = (shared) ? definition.initialise(this) : definition;
        services.put(name, o);
    }
    
    /**
     * Sets a service to be managed by the DI.
     * @param name the name of the service.
     * @param definition the service definition.
     */
    public final void set(String name, Service definition) {
        set(name, definition, false);
    }
    
    /**
     * Sets a shared service to be managed by the DI.
     * @param name the name of the service.
     * @param definition the service definition.
     */
    public final void setShared(String name, Service definition) {
        set(name, definition, true);
    }
    
    /**
     * Sets a service to be managed by the DI.
     * @param name the name of the service.
     * @param service the object which this DI will manage.
     * @param shared  whether the same instance should be used or a new instance on each
     * retrieval.
     */
    public final void set(String name, Object service, boolean shared) {
        Object o = (shared) ? service : new Service(){
            @Override
            public Object initialise(DependencyInjector di) {
                return service;
            }
        };
        services.put(name, o);
    }
    
    /**
     * Sets a service to be managed by the DI.
     * @param name the name of the service.
     * @param service the object which this DI will manage.
     */
    public final void set(String name, Object service) {
        set(name, (Object) service, false);
    }
    
    /**
     * Sets a shared service to be managed by the DI.
     * @param name the name of the service.
     * @param service the object which this DI will manage.
     */
    public final void setShared(String name, Object service) {
        set(name, (Object) service, true);
    }
    
    /**
     * Retrieves a service from the DI.
     * @param <T> The type of object which is being retrieved.
     * @param name the name of the service.
     * @return the service or null if no service was found under the {@code name}.
     */
    public final <T extends Object> T get(String name) {
        if(!services.containsKey(name)) {
            return null;
        }
        Object o = services.get(name);
        T t;
        try {
            if(o instanceof Service) {
                o = ((Service)o).initialise(this);
            }

            t = (T) o;
            if(t instanceof InjectionAware) {
                ((InjectionAware)t).setDI(this);
            }
            if(t instanceof EventAware) {
               if(((EventAware)t).getEventManager() == null) {
                   ((EventAware)t).setEventManager(get("eventManager"));
               }
            }
        } catch (ClassCastException e) {
            return null;
        }
        return t;
    }
    
    /**
     * Determines if the DI has a service with a particular name.
     * @param service the name of the service.
     * @return true if the di finds a match, false otherwise.
     */
    public boolean has(String service) {
        return has(service, Object.class);
    }
    
    /**
     * Determines if the DI has a service with a particular name, which can 
     * be casted to a particular object type.
     * @param service the name of the service.
     * @param cls the class of the service object.
     * @return true if the di finds a match, false otherwise.
     */
    public boolean has(String service, Class<?> cls) {
        if(!services.containsKey(service)) {
            return false;
        }
        try {
            cls.cast(services.get(service));
        } catch (ClassCastException e) {return false;}//abuse of exception handling.
        return true;
    }
    
}
