package org.expression;

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
    public Type multiply(Type data);
    
    /**
     * Divide A/B to give C.
     * @param data the data to divide each corresponding element with.
     * @return the computed data structure.
     */
    public Type divide(Type data);
    
    /**
     * Add A+B to give C.
     * @param data the data to add to A to get C.
     * @return the computed data structure.
     */
    public Type plus(Type data);
    
    /**
     * Subtract A-B to give C.
     * @param data the data to subtract from A to get C.
     * @return the computed data structure.
     */
    public Type minus(Type data);
    
    /**
     * Perform A%B to give C (the remainder operator).
     * @param data the data to compute with A to get C.
     * @return the computed data structure.
     */
    public Type remainder(Type data);
    
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
     * @param value the scalar value i.e 1.2 >> 2 = 0.012
     * @return the completed bitwise left operation value.
     */
    public Type bitwiseLeft(Scalar value);
    
    /**
     * Performs a bitwise right using a scalar value.
     * @param value the scalar value i.e 1.2 << 2 = 120
     * @return the completed bitwise right operation value.
     */
    public Type bitwiseRight(Scalar value);
    
    /**
     * Determines if an object is the same capacity as this.
     * @param object the object to compare with.
     * @return TRUE if the capacity is the same, FALSE otherwise.
     */
    public boolean sizeOf(Object object);
    
    /**
     * Forces the implementation of Comparable.compareTo() used in logical operations.
     * {@inheritDoc Comparable.compareTo()}
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
