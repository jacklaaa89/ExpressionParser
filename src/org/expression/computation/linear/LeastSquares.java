package org.expression.computation.linear;

import org.expression.Coordinate;
import org.expression.Scalar;
import org.expression.computation.decomposition.LinearSystemDecompositor;
import org.expression.computation.decomposition.QRDecomposition;
import org.expression.structure.Matrix;
import org.expression.structure.Predicate;
import org.expression.structure.Vector;

/**
 *
 * @author jacktimblin
 */
public class LeastSquares extends AbstractSolver implements Solver {

    public LeastSquares(Matrix A) {
        super(A);
    }

    @Override
    public Vector solve(Vector b) {
        int m = equations; int n = unknowns;
        
        if(!A.is(Predicate.FULL_RANK)) {
            throw new ArithmeticException("coefficient matrix A cannot be solved, it is not full rank");
        }
        
        QRDecomposition qrd = A.decompose(LinearSystemDecompositor.QR);
        Matrix qr = qrd.getQR();
        Matrix r = qrd.getR();
        
        Vector x = b.copy();
        
        for(int j = 0; j < n; j++) {
            Scalar a = Scalar.ZERO;
            for(int i = j; i < m; i++) {
                a = a.add(qr.get(i, j).multiply(x.get(i)));
            }
            a = a.negate().divide(qr.get(j, j));
            for(int i = j; i < m; i++) {
                x.set(i, x.get(i).add(a.multiply(qr.get(i, j))));
            }
        }
        for(int j = n - 1; j >= 0; j--) {
            x.set(j, x.get(j).divide(r.get(j, j)));
            for(int i = 0; i < j; i++) {
                x.set(i, x.get(i).subtract(x.get(j).multiply(qr.get(i, j))));
            }
        }
        
        return x;
        
    }
    
}
