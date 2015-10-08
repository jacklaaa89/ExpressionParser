package org.expression.computation;

import org.expression.Scalar;
import org.expression.Type;

/**
 * Interface in which arithmetic functions are declared.
 * @author Jack Timblin
 * @param <T> The data structure.
 */
public interface Arithmetic<T extends Type> extends Type<T> {
    
    /**
     * Multiply A*B to give C.
     * @param data the data to multiply this data structure with.
     * @return the computed data structure.
     */
    public Arithmetic mult(Type data);
    
    /**
     * Negates a value (or all values in a structure)
     * @return the value after all values have been negated.
     */
    public Arithmetic neg();
    
    /**
     * Makes a value (or all values in a structure) positive.
     * @return the value after all of the values have been made positive.
     */
    public Arithmetic pos();
    
    /**
     * Returns the absolute value for this value.
     * @return the absolute value for this value.
     */
    public Arithmetic absolute();
    
    /**
     * Divide A/B to give C.
     * @param data the data to divide each corresponding element with.
     * @return the computed data structure.
     */
    public Arithmetic div(Type data);
    
    /**
     * Add A+B to give C.
     * @param data the data to add to A to get C.
     * @return the computed data structure.
     */
    public Arithmetic plus(Type data);
    
    /**
     * Subtract A-B to give C.
     * @param data the data to subtract from A to get C.
     * @return the computed data structure.
     */
    public Arithmetic minus(Type data);
    
    /**
     * Perform A%B to give C (the remainder operator).
     * @param data the data to compute with A to get C.
     * @return the computed data structure.
     */
    public Arithmetic mod(Type data);
    
    /**
     * Calculate the smallest value.
     * @return the smallest value.
     */
    public Scalar min();
    
    /**
     * Calculate the largest value.
     * @return the largest value.
     */
    public Scalar max();
    
    /**
     * Calculate the total sum of all the values.
     * @return the total sum.
     */
    public Scalar sum();
    
    /**
     * Performs a bitwise left using a scalar value.
     * @param value the scalar value
     * @return the completed bitwise left operation value.
     */
    public Arithmetic bitwiseLeft(Scalar value);
    
    /**
     * Performs a bitwise right using a scalar value.
     * @param value the scalar value
     * @return the completed bitwise right operation value.
     */
    public Arithmetic bitwiseRight(Scalar value);
    
    /**
     * Determines if an object is the same capacity as this.
     * @param object the object to compare with.
     * @return TRUE if the capacity is the same, FALSE otherwise.
     */
    public boolean sizeOf(Object object);
    
    /**
     * Forces the implementation of Comparable.compareTo() used in logical operations.
     * @param o the object to compare to.
     * @return -1, 0 or 1 dependant on whether the object is deemed smaller, equal or larger 
     * than this.
     */
    public int compareTo(Type o);
    
    /**
     * {@inheritDoc }
     */
    @Override
    public boolean equals(Object o);
}
