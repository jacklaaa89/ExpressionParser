package org.expression.computation.inverse;

import org.expression.structure.Matrix;

/**
 * An interface for Inverters, which are used to calculate the inverse of a matrix.
 * @author Jack Timblin
 */
public interface Inverter {
    /**
     * return the coefficient Matrix A.
     * @return A
     */
    public Matrix getA();
    
    /**
     * calculates the inverse matrix of matrix A. (A^-1)
     * @return A^-1
     */
    public Matrix inverse();
}
