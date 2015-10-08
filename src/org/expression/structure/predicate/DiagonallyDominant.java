package org.expression.structure.predicate;

import org.expression.Scalar;
import org.expression.Type;
import org.expression.computation.linear.AbstractSolver;
import org.expression.structure.Matrix;
import org.expression.structure.MatrixPredicate;
import org.expression.structure.Predicate;

/**
 *
 * @author jacktimblin
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
                    sum.plus((Scalar)A.get(i, j).absolute());
                }
            }
            Scalar e = (Scalar) A.get(i, i).absolute().minus(new Scalar(AbstractSolver.EPSILON));
            if(sum.compareTo((Type)e) == 1) {
                return false;
            }
        }
        return true;
    }
    
}
