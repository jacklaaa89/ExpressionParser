package org.expression.structure.function;

import org.expression.Scalar;

/**
 * A Function which is applied to a particular element in a Vector.
 * @author Jack Timblin
 */
public interface VectorFunction {
    /**
     * Evaluates the new value at index {@code i}.
     * @param i the row index.
     * @param value the current value at index {@code i}.
     * @return the value after computation has taken place.
     */
    public Scalar evaluate(int i, Scalar value);
}
