package org.expression.computation.decomposition;

import org.expression.structure.Matrix;

/**
 * An interface for a Decompositor, which is used to decompose Matrices.
 * @author Jack Timblin
 */
public interface Decompositor {
    /**
     * get the coefficient matrix A.
     * @return the coefficient matrix A.
     */
    public Matrix getA();
    /**
     * Attempts to decompose the coefficient matrix A.
     */
    public void decompose();
}
