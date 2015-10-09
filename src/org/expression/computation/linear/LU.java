package org.expression.computation.linear;

import org.expression.Scalar;
import org.expression.computation.decomposition.LUDecompositor;
import org.expression.computation.decomposition.LinearSystemDecompositor;
import org.expression.structure.Matrix;
import org.expression.structure.Vector;

/**
 * Attempts to solve a system of equations using LU Factorization.
 * @author Jack Timblin
 */
public class LU extends AbstractSolver implements Solver {
    
    /**
     * The decomposer used to decompose A into { L, U, P } where A = PLU
     */
    private final LUDecompositor decompositor;
    
    /**
     * Initializes the solver, decomposing the matrix using LU Factorization.
     * @param A the coefficient matrix to solve for.
     */
    public LU(Matrix A) {
        super(A);
        decompositor = A.decompose(LinearSystemDecompositor.LU);
        
    }
    
    @Override
    public Vector solve(Vector b) {
        int n = this.getUnknowns();
        Matrix lu = decompositor.getLU();
        Matrix p  = decompositor.getP();
        
        for(int i = 0; i < n; i++) {
            if(lu.get(i, i).equals(Scalar.ZERO)) {
                throw new ArithmeticException("This system is singular");
            }
        }
        
        Vector x = Vector.zeroes(n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!p.get(i, j).equals(Scalar.ZERO)) {
                    x.set(i, b.get(j));
                    break;
                }
            }
        }
        
        for(int j = 0; j < n; j++) {
            for(int i = j + 1; i < n; i++) {
                Scalar m = x.get(j).multiply(lu.get(i, j));
                x.set(i, x.get(i).subtract(m));
            }
        }
        
        for(int j = n - 1; j >= 0; j--) {
            x.set(j, (Scalar) x.get(j).divide(lu.get(j, j)));
            for(int i = 0; i < j; i++) {
                Scalar e = x.get(j).multiply(lu.get(i, j));
                x.set(i, x.get(i).subtract(e));
            }
        }
        
        return x;
    }
    
}
