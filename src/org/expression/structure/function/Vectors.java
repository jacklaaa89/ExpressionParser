package org.expression.structure.function;

import org.expression.Scalar;

/**
 * A generic set of utility methods for Vectors.
 * @author Jack Timblin
 */
public class Vectors {
    /**
     * Generates a VectorFunction which adds a value to the value at the index.
     * @param arg the value to add.
     * @return a VectorFunction
     */
    public static VectorFunction ADD(final Scalar arg) {
        return (int i, Scalar value) -> value.add(arg);
    }
    /**
     * Generates a VectorFunction which subtracts a value to the value at the index.
     * @param arg the value to subtract.
     * @return a VectorFunction
     */
    public static VectorFunction SUBTRACT(final Scalar arg) {
        return (int i, Scalar value) -> value.subtract(arg);
    }
    /**
     * Generates a VectorFunction which multiplies a value to the value at the index.
     * @param arg the value to multiply.
     * @return a VectorFunction
     */
    public static VectorFunction MULTIPLY(final Scalar arg) {
        return (int i, Scalar value) -> value.multiply(arg);
    }
    /**
     * Generates a VectorFunction which divides a value to the value at the index.
     * @param arg the value to divide.
     * @return a VectorFunction
     */
    public static VectorFunction DIVIDE(final Scalar arg) {
        return (int i, Scalar value) -> value.divide(arg);
    }
    /**
     * Generates a VectorFunction which calculates the remainder for a value to the value at the index.
     * @param arg the value to calculate the remainder for.
     * @return a VectorFunction
     */
    public static VectorFunction REMAINDER(final Scalar arg) {
        return (int i, Scalar value) -> value.remainder(arg);
    }
    /**
     * Increments a value by one at an index.
     * @return a VectorFunction
     */
    public static VectorFunction INCREMENT() {
        return (int i, Scalar value) -> value.increment();
    }
    /**
     * Decrements a value by one at an index.
     * @return a VectorFunction
     */
    public static VectorFunction DECREMENT() {
        return (int i, Scalar value) -> value.decrement();
    }
}
