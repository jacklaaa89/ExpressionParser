package org.expression.structure.predicate;

import org.expression.structure.Matrix;
import org.expression.structure.MatrixPredicate;

/**
 * Determines if Matrix A has full rank (its rank is equal to its rows size)
 * @author Jack Timblin
 */
public class FullRank implements MatrixPredicate {

    @Override
    public boolean test(Matrix A) {
        return A.rank().intValue() == A.getRowSize();
    }
    
}
