package org.expression.api;

/**
 * Interface which all classes that need access to the dependency injector.
 * @author Jack Timblin
 */
public interface InjectionAware {
    
    /**
     * Sets the dependency injector.
     * @param di the dependency injector
     */
    public void setDI(DependencyInjector di);
    
    /**
     * Gets the dependency injector.
     * @return the dependency injector
     */
    public DependencyInjector getDI();
}
