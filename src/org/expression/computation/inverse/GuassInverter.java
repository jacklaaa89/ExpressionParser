package org.expression.computation.inverse;

import org.expression.Scalar;
import org.expression.structure.Matrix;

/**
 * Calculate the inverse of A using Guassian Elimination.
 * @author Jack Timblin
 */
public class GuassInverter extends AbstractInverter implements Inverter {
    
    public GuassInverter(Matrix A) {
        super(A);
    }

    @Override
    public Matrix inverse() {
        if(!this.hasAnInverse()) {
            throw new ArithmeticException("Matrix A does not have an inverse.");
        }
        
        Scalar var;
        Matrix result = A.copy();
        
        for(int k = 0; k < A.getRowSize(); k++) {
            Scalar dt = result.get(k, k);
            if(dt.abs().doubleValue() <= Double.MIN_VALUE) {
                throw new ArithmeticException("");
            }
            var = (Scalar) Scalar.ONE.divide(result.get(k, k));
            result.set(k, k, Scalar.ONE);
            for(int j = 0; j < A.getRowSize(); j++) {
                result.set(k, j, (Scalar) result.get(k, j).multiply(var));
            }
            for(int i = 0; i < A.getRowSize(); i++) {
                if(i == k) {
                    continue;
                }
                var = result.get(i, k);
                result.set(i, k, Scalar.ZERO);
                for(int j = 0; j < A.getRowSize(); j++) {
                    result.set(i, j, (Scalar) result.get(i, j).subtract(var.multiply(result.get(k, j))));
                }
            }
        }
        
        return result;
    }
    
}
