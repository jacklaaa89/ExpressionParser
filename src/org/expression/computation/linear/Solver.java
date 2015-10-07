package org.expression.computation.linear;

import org.expression.structure.Matrix;
import org.expression.structure.Vector;

/**
 * Interface which all linear system solvers should implement.
 * @author Jack Timblin
 */
public interface Solver {
    
    /**
     * Solves the set of linear equations with the provided RHS.
     * @param b the RHS values.
     * @return the solved vector of unknown values.
     */
    public Vector solve(Vector b);
    
    /**
     * gets the amount of unknown values to solve.
     * @return the amount of unknown values.
     */
    public int getUnknowns();
    
    /**
     * returns A in Ax = b;
     * @return the matrix A.
     */
    public Matrix getA();
    
    /**
     * gets the amount of equations to solve for.
     * @return the amount of equations to solve for.
     */
    public int getEquations();
}
