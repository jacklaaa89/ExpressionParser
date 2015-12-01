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
     * Initialises an Event.
     * @param source the source object.
     * @param eventTriggered the event that was triggered.
     * @param exception any exception attached to this event.
     */
    public Event(T source, String eventTriggered, Exception exception) {
        this.source = source;
        this.eventTriggered = eventTriggered;
        this.e = exception;
    }
    
    /**
     * Initialises an Event.
     * @param source the source object.
     * @param eventTriggered the event that was triggered.
     */
    public Event(T source, String eventTriggered) {
        this(source, eventTriggered, null);
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
