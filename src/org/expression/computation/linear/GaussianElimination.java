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
        if(!this.isRightHandSideCorrect(b)) {
            throw new ArithmeticException("the amount of values in b doesn't match that of the equations in A");
        }
        
        Matrix augmented = pivot(this.getA().addColumn(b));
        return backSubstitution(augmented);
        
    }
    
    /**
     * Applies partial pivoting to the augmented matrix.
     * @param augmented the augmented matrix.
     * @return the matrix after pivoting has occurred.
     */
    private Matrix pivot(Matrix augmented) {
        
        for(int i = 0; i < augmented.getRowSize(); i++) {
            
            int mi = i;
            Scalar mii = (Scalar) augmented.get(i, i).absolute();
            
            for(int j = i + 1; j < augmented.getRowSize(); j++) {
                Scalar v = (Scalar) augmented.get(j, i).absolute();
                if(mii.compareTo((Type)v) == 1) {
                    mi = j; mii = v;
                }
            }
            
            if(mii.equals(Scalar.ZERO)) {
                throw new ArithmeticException("this system cannot be solved");
            }
            
            if(mi > i) {
                augmented.swap(mi, i);
            }
            
            for(int k = i + 1; k < augmented.getRowSize(); k++) {
                Scalar c = (Scalar) augmented.get(k, i).divide((Type)augmented.get(i, i));
                augmented.add(k, i, new Scalar(0d));
                
                for(int j = i + 1; j < augmented.getColumnSize(); j++) {
                    Scalar kj = augmented.get(k, j);
                    Scalar ij = augmented.get(i, j);
                    ij = (Scalar) ij.multiply((Type)c);
                    augmented.add(k, j, (Scalar) kj.minus(ij));
                }
                
            }
            
        }
        
        return augmented;
    }
    
    /**
     * Attempts to perform back substitution on an augmented
     * matrix to solve for x.
     * @param augmented the augmented matrix after pivoting has taken place.
     * @return the Vector x where Ax = b (or [Ab] = x)
     */
    private Vector backSubstitution(Matrix augmented) {
        
        Vector v = Vector.zeroes(augmented.getColumnSize() - 1);
        
        for(int i = augmented.getRowSize() - 1; i >= 0; i--) {
            Scalar a = Scalar.ZERO;
            
            for(int j = i + 1; j < augmented.getColumnSize() - 1; j++) {
                Scalar s = (Scalar) v.get(i).multiply((Type)augmented.get(i, j));
                a = (Scalar) a.plus(s);
            }
            
            Scalar e = augmented.get(i, augmented.getColumnSize() - 1);
            e = (Scalar) e.minus(a);
            v.set(i, (Scalar) e.divide((Type)augmented.get(i, i)));
        }
        
        return v;
    }
    
}
