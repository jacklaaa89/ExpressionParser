package org.expression.structure;

/**
 * A Matrix Predicate is a test to see if a Matrix passes 
 * a constraint placed against it. i.e if a Matrix is square.
 * @author Jack Timblin
 */
public interface MatrixPredicate {
    /**
     * Tests the matrix.
     * @param A the Matrix to test.
     * @return TRUE if the matrix passes the test, FALSE otherwise.
     */
    public boolean test(Matrix A);
}
