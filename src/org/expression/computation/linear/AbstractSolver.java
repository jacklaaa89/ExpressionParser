package org.expression.computation.linear;

import org.expression.Scalar;
import org.expression.structure.Matrix;
import org.expression.structure.Vector;

/**
 * A base class for any system linear solver.
 * @author Jack Timblin
 */
public abstract class AbstractSolver implements Solver {
    
    /**
     * Machine epsilon.
     */
    public static final double EPSILON = 1e-10;
    
    /**
     * Machine epsilon represented as a Scalar object.
     */
    public static final Scalar EPS_SCALAR = new Scalar(EPSILON);
    
    /**
     * The coefficient matrix A.
     */
    protected Matrix A;
    
    /**
     * The amount of unknown values in the system.
     */
    protected int unknowns;
    
    /**
     * The amount of equations in the system.
     */
    protected int equations;
    
    /**
     * Initializes an AbstractSolver.
     * @param A the Matrix A in Ax = b.
     */
    public AbstractSolver(Matrix A) {
        this.A = A;
        this.unknowns = A.getColumnSize();
        this.equations = A.getRowSize();
    }

    @Override
    public int getUnknowns() {
        return this.unknowns;
    }

    @Override
    public int getEquations() {
        return this.equations;
    }
    
    /**
     * Determines if the dimensions of b agree with A.
     * @param b the RHS values b.
     * @return true if the dimensions agree, false otherwise.
     */
    protected boolean isRightHandSideCorrect(Vector b) {
        return b.size() == this.getEquations();
    }
    
    @Override
    public Matrix getA() {
        return this.A;
    }
    
}
