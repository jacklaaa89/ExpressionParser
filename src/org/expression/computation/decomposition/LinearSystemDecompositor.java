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
     * Single Value Decomposition.
     */
    SINGLE_VALUE {
        @Override
        public AbstractDecompositor get(Matrix A) {
            return new SingleValueDecomposition(A);
        }
    },
    /**
     * The QR Factorization decompositor.
     */
    QR {
        @Override
        public AbstractDecompositor get(Matrix A) {
            return new QRDecomposition(A);
        }
    };
    
    /**
     * Initializes and returns a decomposer for coefficient Matrix A.
     * @param A the coefficient matrix to decompose.
     * @return the decomposer used to decompose matrix A.
     */
    public abstract AbstractDecompositor get(Matrix A);
}
