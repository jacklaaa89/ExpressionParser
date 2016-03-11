package org.expression.exception;

/**
 * Exception triggered when an operation where the dimensions do not agree.
 * Usually applied to Matrix Manipulation.
 * @author Jack Timblin
 */
public class InvalidDimensionsException extends RuntimeException {
    
    /**
     * Initializes a new InvalidDimensionsException
     * @param message the error message.
     */
    public InvalidDimensionsException(String message) {
        super(message);
    }
}
