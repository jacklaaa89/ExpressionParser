package org.expression.structure.predicate;

import org.expression.structure.Matrix;
import org.expression.structure.MatrixPredicate;

/**
 * Predicate to test whether a Matrix is square.
 * @author Jack Timblin
 */
public class Square implements MatrixPredicate {
    @Override
    public boolean test(Matrix A) {
        return A.getColumnSize() == A.getRowSize();
    }
}
