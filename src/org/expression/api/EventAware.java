package org.expression.api;

/**
 * Interface which all classes that need access to the event manager api.
 * @author Jack Timblin
 */
public interface EventAware {
    /**
     * Sets the event manager.
     * @param manager the event manager.
     */
    public void setEventManager(EventManager manager);
    
    /**
     * Get the event manager.
     * @return the event manager.
     */
    public EventManager getEventManager();
}
