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
     * Whether the EventManager should collect responses from event triggers.
     */
    private boolean collectResponses = false;
    
    /**
     * The valid responses from event triggers.
     */
    private final ArrayList<Object> responses;
    
    /**
     * Initialises the EventManager.
     */
    public EventManager() {
        this.triggers = new HashMap<>();
        responses = new ArrayList<>();
    }
    
    public boolean isCollectingResponses() {
        return this.collectResponses;
    }
    
    public void collectResponses(boolean collectResponses) {
        this.collectResponses = collectResponses;
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
     * @param isCancellable whether the event can be cancelled.
     */
    public void fire(
            String event, 
            Object source, 
            Exception ex, 
            boolean isCancellable) {
        responses.clear(); //remove all old responses.
        String[] e = (event.contains(":")) ? event.trim().split(":") : new String[] {event};
        if(e.length == 0) {
            return;
        }
        
        Event ev = new Event(source, event, ex, isCancellable);
        String namespace = e[0];
        
        if(triggers.containsKey(namespace)) {
            for(EventListener el : triggers.get(namespace)) {
                Object re = el.eventTriggered(ev);
                if(isCollectingResponses() && re != null) {
                    responses.add(re);
                }
                if(ev.isStopped()) {
                    break;
                }
            }
        }
        if(!ev.isStopped()) {
            if(triggers.containsKey(event)) {
                for(EventListener el : triggers.get(event)) {
                    Object re = el.eventTriggered(ev);
                    if(isCollectingResponses() && re != null) {
                        responses.add(re);
                    }
                    if(ev.isStopped()) {
                        break;
                    }
                }
            }
        }
        
    }
    
    /**
     * Gets any collected responses, will return an empty list if no valid responses
     * were collected or collect response is not true.
     * @return the list of responses.
     */
    public ArrayList<Object> getResponses() {
        return responses;
    }
    
    @Override
    public String toString() {
        return this.triggers.toString();
    }
    
}
