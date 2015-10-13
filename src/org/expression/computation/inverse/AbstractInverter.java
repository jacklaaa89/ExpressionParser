package org.expression.computation.inverse;

import org.expression.Scalar;
import org.expression.structure.Matrix;
import org.expression.structure.Predicate;

/**
 * Base Inverter classes, providing generic methods.
 * @author Jack Timblin
 */
public abstract class AbstractInverter implements Inverter {
    
    /**
     * The coefficient Matrix A.
     */
    protected Matrix A;
    
    /**
     * Initializes the invert, providing the Matrix to invert.
     * @param A The matrix to invert.
     */
    public AbstractInverter(Matrix A) {
        this.A = A;
    }
    
    @Override
    public Matrix getA() {
        return this.A;
    }
    
    /**
     * Determines if the coefficient matrix A does have an inverse.
     * This is determined by whether the matrix is square, has full rank
     * and the determinant is greater than zero.
     * @return true if this matrix can be inverted, false otherwise.
     */
    public boolean hasAnInverse() {
        return A.is(Predicate.SQUARE) 
                && A.is(Predicate.FULL_RANK)
                && !A.determinant().equals(Scalar.ZERO);
    }
    
}
