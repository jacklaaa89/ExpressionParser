package org.expression.computation;

import org.expression.Scalar;

/**
 * An interface which is used when iterating over Vectors/Matrices 
 * and applying this handler to each particular element.
 * @author Jack Timblin
 */
public interface Handler {
    
    /**
     * This function returns a new element to place in a Vector/Matrix
     * after providing the previously allocated element.
     * @param o1 the element previously stored at point i(j) in a Vector/Matrix.
     * @return The new element after carrying out some computation.
     */
    public Scalar handle(Scalar o1);
    
}
