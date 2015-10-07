package org.expression;

import org.expression.structure.Matrix;
import org.expression.structure.Vector;

/**
 * An encapsulation of an expression result, either a fragment in the expression or
 * the overall expression itself. 
 * i.e (1 + 1) - 3 would have two contexts, one for the (1 + 1) and one
 * for the 2 - 3 (the evaluated form of the previous context is on the left.)
 * @author Jack Timblin
 * @param <T> The expected result object.
 */
public class Context<T extends Type> {
    
    /**
     * The evaluated result from this context.
     */
    private T value;
    
    /**
     * Initializes a context, providing it with a result from this evaluation.
     * @param value the value from a single context in the expression.
     */
    public Context(T value) {
        this.value = value;
    }
    
    /**
     * Determines if the result from this context was a Vector.
     * @return <b>TRUE</b> if the evaluated result was a Vector, <b>FALSE</b> otherwise.
     */
    public boolean isArray() {
        return (value instanceof Vector);
    }
    
    /**
     * Determines if the result from this context was a Matrix.
     * @return <b>TRUE</b> if the evaluated result was a Matrix, <b>FALSE</b> otherwise.
     */
    public boolean isMatrix() {
        return (value instanceof Matrix);
    }
    
    /**
     * Determines if the result from this context was a Scalar.
     * @return <b>TRUE</b> if the evaluated result was a Scalar, <b>FALSE</b> otherwise.
     */
    public boolean isScalar() {
        return (value instanceof Scalar);
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    /**
     * Retrieve the evaluated value from this context.
     * @return the evaluated result.
     */
    public T getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        String v = this.value.toString();
        return v;
    }
    
}
