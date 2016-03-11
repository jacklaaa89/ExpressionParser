package org.expression.exception;

import org.expression.computation.Arithmetic;

/**
 * Exception thrown when a Division By Zero is attempted.
 * @author Jack Timblin
 */
public class DivisonByZeroException extends RuntimeException {
    
    /**
     * the left hand context.
     */
    private Arithmetic left;
    
    /**
     * the right hand context.
     */
    private Arithmetic right;
    
    /**
     * Initializes a new DivisionByZeroException.
     * @param message the message.
     * @param left the left hand of the expression.
     * @param right the right hand of the expression.
     */
    public DivisonByZeroException(String message, Arithmetic left, Arithmetic right) {
        super(message);
        this.left = left;
        this.right = right;
    }
    
    /**
     * gets the left hand context.
     * @return the left hand context.
     */
    public Arithmetic getLeftContext() {
        return this.left;
    }
    
    /**
     * gets the right hand context.
     * @return the right hand context.
     */
    public Arithmetic getRightContext() {
        return this.right;
    }
}
