package org.expression.computation.decomposition;

import org.expression.Scalar;
import static org.expression.computation.linear.AbstractSolver.EPS_SCALAR;
import org.expression.structure.Matrix;
import org.expression.structure.Predicate;

/**
 * Decomposes a matrix A in which A = Q*R where R is an upper
 * triangular matrix and Q is an orthogonal matrix. 
 * i.e Q^T*Q = I where Q^T is the tranpose of Q and I is the Identity matrix.
 * @author Jack Timblin
 */
public class QRDecomposition extends AbstractDecompositor implements Decompositor {
    
    private Matrix Q, R, QR;

    public QRDecomposition(Matrix A) {
        super(A);
    }

    @Override
    public void decompose() {
        
        if(!A.is(Predicate.SQUARE)) {
            throw new ArithmeticException("coefficient matrix A could not be decomposed using QR, matrix is not square.");
        }
        
        Matrix qr = A.copy();
        Matrix r = Matrix.zeroes(qr.getColumnSize(), qr.getRowSize());
        for(int k = 0; k < qr.getColumnSize(); k++) {
            Scalar n = Scalar.ZERO;
            for(int i = k; i < qr.getRowSize(); i++) {
                n = Scalar.hypot(n, qr.get(i, k));
            }
            if(n.abs().compareTo(EPS_SCALAR) == 1) {
                if(qr.get(k, k).compareTo(Scalar.ZERO) == -1) {
                    n = n.negate();
                }
                for(int i = k; i < qr.getRowSize(); i++) {
                    qr.set(i, k, qr.get(i, k).divide(n));
                }
                qr.set(k, k, qr.get(k, k).add(Scalar.ONE));
                for(int j = k + 1; j < qr.getColumnSize(); j++) {
                    Scalar a = Scalar.ZERO;
                    for(int i = k; i < qr.getRowSize(); i++) {
                        a = a.add(qr.get(i, k).multiply(qr.get(i, j)));
                    }
                    a = a.negate().divide(qr.get(k, k));
                    for(int i = k; i < qr.getRowSize(); i++) {
                        qr.set(i, j, qr.get(i, j).add((a.multiply(qr.get(i, k)))));
                    }
                }
            }
            r.set(k, k, n.negate());
        }
        this.QR = qr;
        
        Matrix q = Matrix.from(qr);
        for(int k = q.getColumnSize() - 1; k >= 0; k--) {
            q.set(k, k, Scalar.ONE);
            for(int j = k; j < q.getColumnSize(); j++) {
                if(qr.get(k, k).abs().compareTo(EPS_SCALAR) == 1) {
                    Scalar a = Scalar.ZERO;
                    for(int i = k; i < q.getRowSize(); i++) {
                        a = a.add((qr.get(i, k).multiply(q.get(i, j))));
                    }
                    a = a.negate().divide(qr.get(k, k));
                    for(int i = k; i < q.getRowSize(); i++) {
                        q.set(i, j, q.get(i, j).add((a.multiply(qr.get(i, k)))));
                    }
                }
            }
        }
        for(int i = 0; i < r.getRowSize(); i++) {
            for(int j = i + 1; j < r.getColumnSize(); j++) {
                r.set(i, j, qr.get(i, j));
            }
        }
        
        this.Q = q;
        this.R = r;
        
    }
    
    public Matrix getQ() {
        return this.Q;
    }
    
    public Matrix getR() {
        return this.R;
    }
    
    public Matrix getQR() {
        return this.QR;
    }
}
