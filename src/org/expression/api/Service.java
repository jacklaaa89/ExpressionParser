package org.expression.api;

/**
 * Wrapper for service definitions, called by the DI to retrieve object instances.
 * @author Jack Timblin
 */
public interface Service {
    /**
     * Initialises a service from the DI.
     * @param di an instance of the DI to retrieve other system services.
     * @return the object instance.
     */
    public Object initialise(DependencyInjector di);
}
