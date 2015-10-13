package org.expression.computation.linear;

import org.expression.Scalar;
import org.expression.structure.Matrix;
import org.expression.structure.Predicate;
import org.expression.structure.Vector;

/**
 *
 * @author jacktimblin
 */
public class Jacobi extends AbstractSolver implements Solver {
    
    private final Matrix c;
    
    public Jacobi(Matrix A) {
        super(A);
        
        if(!A.is(Predicate.DIAGONALLY_DOMINANT)) {
            throw new ArithmeticException("cannot solve this system of equations using the jacobi method.");
        }
        
        this.c = A.copy();
        
        for(int i = 0; i < c.getRowSize(); i++) {
            Scalar ii = c.get(i, i);
            for(int j = 0; j < c.getColumnSize(); j++) {
                if(i != j) {
                    Scalar a = c.get(i, j);
                    c.set(i, j, (Scalar) a.divide(ii));
                }
            }
        }
        
    }
    
    @Override
    public Vector solve(Vector b) {
        if(!this.isRightHandSideCorrect(b)) {
            throw new ArithmeticException("");
        }
        
        Vector current = Vector.zeroes(getUnknowns());
        while(!A.multiply(current).equals(b)) {
            Vector next = Vector.zeroes(current.size());
            for(int i = 0; i < c.getRowSize(); i++) {
                Scalar a = (Scalar) b.get(i).divide(c.get(i, i));
                for(int j = 0; j < c.getColumnSize(); j++) {
                    if(i != j) {
                        Scalar e = (Scalar) c.get(i, j).multiply(current.get(j));
                        a = (Scalar) a.subtract(e);
                    }
                }
                next.set(i, a);
            }
            current = next;
        }
        return current;
    }
    
}
