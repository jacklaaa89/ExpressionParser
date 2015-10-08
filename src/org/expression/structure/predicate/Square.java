/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.expression.structure.predicate;

import org.expression.structure.Matrix;
import org.expression.structure.MatrixPredicate;

/**
 *
 * @author jacktimblin
 */
public class Square implements MatrixPredicate {
    @Override
    public boolean test(Matrix A) {
        return A.getColumnSize() == A.getRowSize();
    }
}
