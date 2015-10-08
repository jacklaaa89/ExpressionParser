package org.expression.computation.linear;

import org.expression.Scalar;
import org.expression.Type;
import org.expression.structure.Matrix;
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
        if(!A.isSquare()) {
            throw new ArithmeticException("Matrix A must be a square system.");
        }
    }
    
    @Override
    public Vector solve(Vector b) {
        int N = b.size();
        
        for(int p = 0; p < N; p++) {
           int max = p;
           for(int i = p + 1; i < N; i++) {
               Scalar ip = (Scalar) A.get(i, p).absolute();
               Scalar maxp = (Scalar) A.get(max, p).absolute();
               if(ip.compareTo((Type)maxp) == 1) {
                   max = i;
               }
           }
           
           A.swap(p, max);
           b.swap(p, max);
           
           Scalar c = (Scalar) A.get(p, p).absolute();
           if(c.doubleValue() <= EPSILON) {
               throw new ArithmeticException("Matrix is singular or nearly singular");
           }
           
           for(int i = p + 1; i < N; i++) {
               Scalar alp = (Scalar) A.get(i, p).div(A.get(p, p));
               Scalar e = (Scalar) alp.mult(b.get(p));
               b.set(i, (Scalar) b.get(i).minus(e));
               for(int j = p; j < N; j++) {
                   Scalar m = (Scalar) alp.mult(A.get(p, j));
                   A.set(i, j, (Scalar) A.get(i, j).minus(m));
               }
            }
        }
        
        Vector x = new Vector(N);
        for(int i = N - 1; i >= 0; i--) {
            Scalar su = Scalar.ZERO;
            for(int j = i + 1; j < N; j++) {
                Scalar m = (Scalar) A.get(i, j).mult(x.get(j));
                su = (Scalar) su.plus(m);
            }
            Scalar n = (Scalar) b.get(i).minus(su);
            x.set(i, (Scalar) n.div(A.get(i, i)));
        }
        
        return x;
        
    }
    
}
