package org.expression.api;

import org.expression.api.exception.DispatchException;

/**
 * The interface which is triggered on an event.
 * @author Jack Timblin
 */
public interface EventListener<T> {
    /**
     * Triggered when an attached event is fired.
     * @param event the event that was fired.
     * @return Any object which needs to be collected, returning null avoids an object to be 
     * collected.
     * @throws DispatchException if the event should stop execution at this point.
     */
    public Object eventTriggered(Event<T> event) throws DispatchException;
}
