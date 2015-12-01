package org.expression.api;

/**
 * An encapsulation of an event when triggered by the Event Manager.
 * @author Jack Timblin
 */
public class Event<T> {
    
    /**
     * The object which triggered the event.
     */
    private final T source;
    
    /**
     * The event that was triggered.
     */
    private final String eventTriggered;
    
    /**
     * Any exception which was passed with this event.
     */
    private final Exception e;
    
    /**
     * Whether this Event can be cancelled.
     */
    private final boolean isCancellable;
    
    /**
     * Whether this event has been stopped.
     */
    private boolean isStopped = false;
    
    /**
     * Initialises an Event.
     * @param source the source object.
     * @param eventTriggered the event that was triggered.
     * @param exception any exception attached to this event.
     * @param isCancellable whether this event can be cancelled.
     */
    public Event(T source, String eventTriggered, Exception exception, boolean isCancellable) {
        this.source = source;
        this.eventTriggered = eventTriggered;
        this.e = exception;
        this.isCancellable = isCancellable; 
    }
    
    /**
     * Determine if this event is cancellable, i.e event propagation can be stopped.
     * @return true if event propagation can be cancelled, false otherwise. 
     */
    public boolean isCancellable() {
        return this.isCancellable;
    }
    
    /**
     * Attempts to stop event propagation from this event.
     */
    public void stop() {
        if(!this.isCancellable()) {
            throw new RuntimeException("This event is not cancellable");
        }
        this.isStopped = true;
    }
    
    /**
     * Determines if event propagation has been stopped.
     * @return true if it has been stopped, false otherwise.
     */
    public boolean isStopped() {
        return this.isStopped;
    }
    
    /**
     * get the source object which triggered the event.
     * @return the source object.
     */
    public T getSource() {
        return this.source;
    }
    
    /**
     * Gets the event that was triggered.
     * @return the event that was triggered.
     */
    public String getEventTriggered() {
        return this.eventTriggered;
    }
    
    /**
     * Gets any exception attached to this event.
     * @return the exception.
     */
    public Exception getException() {
        return this.e;
    }
    
}
