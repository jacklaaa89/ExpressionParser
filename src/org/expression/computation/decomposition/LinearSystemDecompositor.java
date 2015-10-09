package org.expression.computation.decomposition;

import org.expression.structure.Matrix;

/**
 * A collection of Matrix decompositors.
 * @author Jack Timblin
 */
public enum LinearSystemDecompositor {
    /**
     * The LU Factorization decomposer. 
     */
    LU {
        @Override
        public AbstractDecompositor get(Matrix A) {
            return new LUDecompositor(A);
        }
    },
    /**
     * The LU Factorization decomposer. 
     */
    SINGLE_VALUE {
        @Override
        public AbstractDecompositor get(Matrix A) {
            return new SingleValueDecomposition(A);
        }
    };;
    
    /**
     * Initializes and returns a decomposer for coefficient Matrix A.
     * @param A the coefficient matrix to decompose.
     * @return the decomposer used to decompose matrix A.
     */
    public abstract AbstractDecompositor get(Matrix A);
}
