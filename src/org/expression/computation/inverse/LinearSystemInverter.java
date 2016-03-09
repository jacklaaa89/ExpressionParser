package org.expression.computation.inverse;

import org.expression.structure.Matrix;

/**
 * A collection of Linear System Inverters to Invert Systems of Linear Equations.
 * @author Jack Timblin
 */
public enum LinearSystemInverter {
    /**
     * Calculates the inverse of Matrix A using Guassian Elimination
     */
    GAUSS {
        @Override
        public AbstractInverter get(Matrix A) {
            return new GuassInverter(A);
        }
    };
    public abstract AbstractInverter get(Matrix A);
}
