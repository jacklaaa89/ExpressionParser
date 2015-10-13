package org.expression.structure.function;

import org.expression.Scalar;

/**
 * A Function which is applied to a particular element in a Matrix.
 * @author Jack Timblin
 */
public interface MatrixFunction {
    /**
     * Evaluates the new value at index {@code i}, {@code j}
     * @param i the row index.
     * @param j the column index.
     * @param value the current value at index {@code i}, {@code j}
     * @return the value after computation has taken place.
     */
    public Scalar evaluate(int i, int j, Scalar value);
}
