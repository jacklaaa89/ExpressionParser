package org.expression.computation.decomposition;

import org.expression.Scalar;
import static org.expression.computation.linear.AbstractSolver.EPS_SCALAR;
import org.expression.structure.Matrix;

/**
 * Attempts to decompose Matrix A using LU Factorization.
 * @author Jack Timblin
 */
public class LUDecompositor extends AbstractDecompositor implements Decompositor {
    
    /**
     * Lower triangular Matrix.
     */
    private Matrix L;
    
    /**
     * Upper triangular Matrix.
     */
    private Matrix U;
    
    /**
     * The permutation Matrix P (Pivot).
     */
    private Matrix P;
    
    /**
     * The combined LU matrix.
     */
    private Matrix LU;
    
    public LUDecompositor(Matrix A) {
        super(A);
    }
    
    @Override
    public void decompose() {
        Matrix lu = A.copy();
        Matrix p = Matrix.identity(lu.getRowSize());
        
        for(int j = 0; j < lu.getColumnSize(); j++) {
            for(int i = 0; i < lu.getRowSize(); i++) {
                
                int m = Math.min(i, j);
                Scalar z = Scalar.ZERO;
                
                for(int k = 0; k < m; k++) {
                    Scalar e = lu.get(i, k).multiply(lu.get(k, j));
                    z = z.add(e);
                }
                lu.set(i, j, lu.get(i, j).subtract(z));
            }
            int pivot = j;
            for(int i = j + 1; i < lu.getRowSize(); i++) {
                if(lu.get(i, j).abs().compareTo(lu.get(pivot, j).abs()) == 1) {
                    pivot = i;
                }
            }
            
            if(pivot != j) {
                lu.swap(pivot, j);
                p.swap(pivot, j);
            }
            
            if(j < lu.getRowSize() && lu.get(j, j).abs().compareTo(EPS_SCALAR) == 1) {
                for(int i = j + 1; i < lu.getRowSize(); i++) {
                    Scalar e = (Scalar) lu.get(i, j).divide(lu.get(j, j));
                    lu.set(i, j, e);
                }
            }   
        }
        
        this.LU = lu;
        
        Matrix l = Matrix.zeroes(lu.getColumnSize(), lu.getRowSize());
        for(int i = 0; i < l.getRowSize(); i++) {
            for(int j = 0; j <= i; j++) {
                if(i > j) {
                    l.set(i, j, lu.get(i, j));
                } else {
                    l.set(i, j, Scalar.ONE);
                }
            }
        }
        
        Matrix u = Matrix.zeroes(lu.getColumnSize(), lu.getRowSize());
        for(int i = 0; i < u.getRowSize(); i++) {
            for(int j = i; j < u.getColumnSize(); j++) {
                u.set(i, j, lu.get(i, j));
            }
        }
        
        this.L = l; this.U = u; this.P = p;
    }
    
    /**
     * return lower triangular factor.
     * @return the lower triangular factor.
     */
    public Matrix getL() {
        return this.L;
    }
    
    /**
     * return upper triangular factor.
     * @return the upper triangular factor.
     */
    public Matrix getU() {
        return this.U;
    }
    
    /**
     * returns the permutation matrix.
     * @return the permutation matrix P.
     */
    public Matrix getP() {
        return this.P;
    }
    
    /**
     * returns the combined LU Matrix.
     * @return the combined LU matrix.
     */
    public Matrix getLU() {
        return this.LU;
    }
    
}
