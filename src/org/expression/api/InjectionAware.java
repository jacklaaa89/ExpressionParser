package org.expression.api;

/**
 *
 * @author Jack
 */
public interface InjectionAware {
    public void setDI(DependencyInjector di);
    public DependencyInjector getDI();
}
