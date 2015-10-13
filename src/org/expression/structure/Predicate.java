package org.expression.structure;

import org.expression.structure.predicate.DiagonallyDominant;
import org.expression.structure.predicate.FullRank;
import org.expression.structure.predicate.Square;

/**
 * A set of predicates to use when testing a Matrix.
 * @author Jack Timblin
 */
public enum Predicate {
    /**
     * Used to test to see if a Matrix is diagonally dominant.
     */
    DIAGONALLY_DOMINANT {
      @Override
      public boolean test(Matrix A) {
          return new DiagonallyDominant().test(A);
      }
    },
    /**
     * Used to test to see if a Matrix is square.
     */
    SQUARE {
        @Override
        public boolean test(Matrix A) {
            return new Square().test(A);
        }
    },
    /**
     * Used to test to see if a Matrix is of full rank.
     */
    FULL_RANK {
        @Override
        public boolean test(Matrix A) {
            return new FullRank().test(A);
        }
    };
    /**
     * Tests a matrix with a particular predicate.
     * @param A the matrix to test.
     * @return TRUE if the matrix passes, FALSE otherwise.
     */
    public abstract boolean test(Matrix A);
}
