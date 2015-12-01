package org.expression.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Event Manager class which can trigger selected events on a set of listeners.
 * @author Jack Timblin
 */
public class EventManager {
    
    /**
     * The list of currently attached events to listen for.
     */
    private final Map<String, List<EventListener>> triggers;
    
    /**
     * Initialises the EventManager.
     */
    public EventManager() {
        this.triggers = new HashMap<>();
    }
    
    /**
     * Attaches a listener.
     * @param event the event to listen for.
     * @param listener the listener to notify when this event is fired.
     */
    public void attach(String event, EventListener listener) {
        List<EventListener> events = triggers.containsKey(event) ? triggers.get(event) : new ArrayList<>();
        events.add(listener);
        triggers.put(event, events);
    }
    
    /**
     * Fires an event.
     * @param event the event to fire.
     * @param source the source object.
     * @param ex any attached exception for this event.
     */
    public void fire(String event, Object source, Exception ex) {
        String[] e = (event.contains(":")) ? event.trim().split(":") : new String[] {event};
        if(e.length == 0) {
            return;
        }
        
        Event ev = new Event(source, event, ex);
        String namespace = e[0];
        
        if(triggers.containsKey(namespace)) {
            for(EventListener el : triggers.get(namespace)) {
                el.eventTriggered(ev);
            }
        }
        
        if(triggers.containsKey(event)) {
            for(EventListener el : triggers.get(event)) {
                el.eventTriggered(ev);
            }
        }
        
    }
    
    /**
     * Fires an event.
     * @param event the event to fire.
     * @param source the source object.
     */
    public void fire(String event, Object source) {
        fire(event, source, null);
    }
    
    @Override
    public String toString() {
        return this.triggers.toString();
    }
    
}
