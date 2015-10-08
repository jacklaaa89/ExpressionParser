package org.expression.computation.decomposition;

import org.expression.structure.Matrix;

/**
 * Base decompositor classes, providing generic methods.
 * @author Jack Timblin
 */
public abstract class AbstractDecompositor implements Decompositor {
    
    /**
     * The coefficient matrix A.
     */
    protected Matrix A;
    
    /**
     * Initializes the decomposer.
     * @param A the coefficient matrix A.
     */
    public AbstractDecompositor(Matrix A) {
        this.A = A;
    }
    
    @Override
    public Matrix getA() {
        return this.A;
    }
    
}
