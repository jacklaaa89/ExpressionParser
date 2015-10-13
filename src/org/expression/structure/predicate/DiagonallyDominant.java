package org.expression.structure.predicate;

import org.expression.Scalar;
import org.expression.computation.linear.AbstractSolver;
import org.expression.structure.Matrix;
import org.expression.structure.MatrixPredicate;
import org.expression.structure.Predicate;

/**
 * Predicate to test whether a Matrix is diagonally dominant.
 * @author Jack Timblin
 */
public class DiagonallyDominant implements MatrixPredicate {

    @Override
    public boolean test(Matrix A) {
        if(!A.is(Predicate.SQUARE)) {
            return false;
        }
        
        for(int i = 0; i < A.getRowSize(); i++) {
            Scalar sum = Scalar.ZERO;
            for(int j = 0; j < A.getColumnSize(); j++) {
                if(i != j) {
                    sum.add((Scalar)A.get(i, j).abs());
                }
            }
            Scalar e = (Scalar) A.get(i, i).abs().subtract(new Scalar(AbstractSolver.EPSILON));
            if(sum.compareTo(e) == 1) {
                return false;
            }
        }
        return true;
    }
    
}
