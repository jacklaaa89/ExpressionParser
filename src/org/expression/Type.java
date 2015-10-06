package org.expression;

/**
 * An interface which all data types implement to use as a generic 'type'
 * @author Jack Timblin
 * @param <T> the type of Object to return.
 */
public interface Type<T extends Type> {
    /**
     * Applies a handler to each element in this type.
     * @param handler the handler to apply.
     * @return the data structure after the handler has been applied to each element.
     */
    public T apply(Handler handler);
    
    /**
     * Applies a handler to each element in this type from a pre-defined handler.
     * @param function the handler to apply.
     * @return the data structure after the handler has been applied to each element.
     */
    public T apply(Functions function);
}
