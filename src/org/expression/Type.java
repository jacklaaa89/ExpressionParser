package org.expression;

/**
 * An interface which all data types implement to use as a generic 'type'
 * @author Jack Timblin
 * @param <T> the type of Object to return.
 */
public interface Type<T extends Type> {
    public T apply(Handler handler);
}
