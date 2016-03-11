package org.expression.exception;

import org.expression.computation.Arithmetic;
import org.expression.computation.Operator;

/**
 * Exception triggered when an unsupported operation is attempted.
 * @author Jack Timblin
 */
public class UnsupportedOperationException extends RuntimeException {
    
    /**
     * the left hand context.
     */
    private Arithmetic left;
    
    /**
     * the right hand context.
     */
    private Arithmetic right;
    
    /**
     * the attempted operator.
     */
    private Operator operator;
    
    /**
     * Initializes a new UnsupportedOperationException
     * @param message the error message.
     * @param left the left hand side of the expression
     * @param right the right hand side of the expression.
     * @param operator the attempted operator.
     */
    public UnsupportedOperationException(String message, Arithmetic left, Arithmetic right, Operator operator) {
        super(message);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }
    
    /**
     * gets the left context.
     * @return the left context.
     */
    public Arithmetic getLeftContext() {
        return this.left;
    }
    
    /**
     * gets the right context.
     * @return the right context.
     */
    public Arithmetic getRightContext() {
        return this.right;
    }
    
    /**
     * gets the attempted operator.
     * @return the attempted operator.
     */
    public Operator getOperator() {
        return this.operator;
    }
}
