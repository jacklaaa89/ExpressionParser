package org.expression.exception;

/**
 * Exception triggered when an operation is attempted on an empty context.
 * @author Jack Timblin
 */
public class EmptyContextOperationException extends RuntimeException {
    
    /**
     * Initializes a new EmptyContextOperationException.
     * @param message the error message.
     */
    public EmptyContextOperationException(String message) {
        super(message);
    }
}
