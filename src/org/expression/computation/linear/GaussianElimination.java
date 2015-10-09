package org.expression.computation.linear;

import org.expression.Scalar;
import org.expression.structure.Matrix;
import org.expression.structure.Predicate;
import org.expression.structure.Vector;

/**
 * Attempts to solve a linear system of equations using Gaussian Elimination.
 * @author Jack Timblin
 */
public class GaussianElimination extends AbstractSolver implements Solver {
    
    /**
     * Initializes the Solver, and determines if the system is square.
     * @param A the Matrix A in Ax = b
     */
    public GaussianElimination(Matrix A) {
        super(A);
        if(!A.is(Predicate.SQUARE)) {
            throw new ArithmeticException("Matrix A must be a square system.");
        }
    }
    
    @Override
    public Vector solve(Vector b) {
        int N = b.size();
        
        for(int p = 0; p < N; p++) {
           int max = p;
           for(int i = p + 1; i < N; i++) {
               Scalar ip = A.get(i, p).abs();
               Scalar maxp = A.get(max, p).abs();
               if(ip.compareTo(maxp) == 1) {
                   max = i;
               }
           }
           
           A.swap(p, max);
           b.swap(p, max);
           
           Scalar c = A.get(p, p).abs();
           if(c.doubleValue() <= EPSILON) {
               throw new ArithmeticException("Matrix is singular or nearly singular");
           }
           
           for(int i = p + 1; i < N; i++) {
               Scalar alp = A.get(i, p).divide(A.get(p, p));
               Scalar e = alp.multiply(b.get(p));
               b.set(i, b.get(i).subtract(e));
               for(int j = p; j < N; j++) {
                   Scalar m = alp.multiply(A.get(p, j));
                   A.set(i, j, A.get(i, j).subtract(m));
               }
            }
        }
        
        Vector x = new Vector(N);
        for(int i = N - 1; i >= 0; i--) {
            Scalar su = Scalar.ZERO;
            for(int j = i + 1; j < N; j++) {
                Scalar m = A.get(i, j).multiply(x.get(j));
                su = su.add(m);
            }
            Scalar n = b.get(i).subtract(su);
            x.set(i, n.divide(A.get(i, i)));
        }
        
        return x;
        
    }
    
}
