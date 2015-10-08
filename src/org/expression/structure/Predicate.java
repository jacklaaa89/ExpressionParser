/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.expression.structure;

import org.expression.structure.predicate.DiagonallyDominant;
import org.expression.structure.predicate.Square;

/**
 *
 * @author jacktimblin
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
    SQUARE {
        @Override
        public boolean test(Matrix A) {
            return new Square().test(A);
        }
    };
    public abstract boolean test(Matrix A);
}
