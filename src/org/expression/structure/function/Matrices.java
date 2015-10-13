package org.expression.structure.function;

import org.expression.Scalar;

/**
 * A generic set of utility methods for Matrices.
 * @author Jack Timblin
 */
public abstract class Matrices {
    /**
     * Generates a MatrixFunction which adds a value to the value at the index.
     * @param arg the value to add.
     * @return a MatrixFunction
     */
    public static MatrixFunction ADD(final Scalar arg) {
        return (int i, int j, Scalar value) -> value.add(arg);
    }
    /**
     * Generates a MatrixFunction which subtracts a value to the value at the index.
     * @param arg the value to subtract.
     * @return a MatrixFunction
     */
    public static MatrixFunction SUBTRACT(final Scalar arg) {
        return (int i, int j, Scalar value) -> value.subtract(arg);
    }
    /**
     * Generates a MatrixFunction which multiplies a value to the value at the index.
     * @param arg the value to multiply.
     * @return a MatrixFunction
     */
    public static MatrixFunction MULTIPLY(final Scalar arg) {
        return (int i, int j, Scalar value) -> value.multiply(arg);
    }
    /**
     * Generates a MatrixFunction which divides a value to the value at the index.
     * @param arg the value to divide.
     * @return a MatrixFunction
     */
    public static MatrixFunction DIVIDE(final Scalar arg) {
        return (int i, int j, Scalar value) -> value.divide(arg);
    }
    /**
     * Generates a MatrixFunction which calculates the remainder for a value to the value at the index.
     * @param arg the value to calculate the remainder for.
     * @return a MatrixFunction
     */
    public static MatrixFunction REMAINDER(final Scalar arg) {
        return (int i, int j, Scalar value) -> value.remainder(arg);
    }
    /**
     * Increments a value by one at an index.
     * @return a MatrixFunction
     */
    public static MatrixFunction INCREMENT() {
        return (int i, int j, Scalar value) -> value.increment();
    }
    /**
     * Decrements a value by one at an index.
     * @return a MatrixFunction
     */
    public static MatrixFunction DECREMENT() {
        return (int i, int j, Scalar value) -> value.decrement();
    }
}
