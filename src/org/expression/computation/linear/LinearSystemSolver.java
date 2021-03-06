package org.expression.computation.linear;

import org.expression.structure.Matrix;

/**
 * A set of linear equation solvers.
 * @author Jack Timblin
 */
public enum LinearSystemSolver {
    /**
     * Solver which solves a system of linear equations using 
     * gaussian elimination.
     */
    GAUSSIAN_ELIMINATION {
        @Override
        public AbstractSolver get(Matrix A) {
            return new GaussianElimination(A);
        }
    },
    /**
     * Solver which solves a system of linear equations using 
     * LU Factorization.
     */
    LU {
        @Override
        public AbstractSolver get(Matrix A) {
            return new LU(A);
        }
    },
    /**
     * Solver which solves a system of linear equations using 
     * Least Squares.
     */
    LEAST_SQUARES {
        @Override
        public AbstractSolver get(Matrix A) {
            return new LeastSquares(A);
        }
    },
    /**
     * Solver which solves a system of linear equations using 
     * the Jacobi method.
     */
    JACOBI {
        @Override
        public AbstractSolver get(Matrix A) {
            return new Jacobi(A);
        }
    };
    
    /**
     * Initializes and gets a solver based on the enum type.
     * @param A the matrix to set as A.
     * @return the linear solver to use on matrix A with RHS b.
     */
    public abstract AbstractSolver get(Matrix A);
}
