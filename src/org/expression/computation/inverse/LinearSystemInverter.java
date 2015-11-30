/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.expression.computation.inverse;

import org.expression.structure.Matrix;

/**
 *
 * @author jacktimblin
 */
public enum LinearSystemInverter {
    GAUSS {
        @Override
        public AbstractInverter get(Matrix A) {
            return new GuassInverter(A);
        }
    };
    public abstract AbstractInverter get(Matrix A);
}
