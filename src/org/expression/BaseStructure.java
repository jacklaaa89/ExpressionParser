package org.expression;

import java.math.MathContext;
import java.util.ArrayList;

/**
 * Data structure base class, It gives data structures some generic methods and initialization.
 * @author Jack Timblin
 * @param <T> The value that this structure holds.
 * @param <O> The type of Object that will be returned when manipulating the structure.
 */
public abstract class BaseStructure<T, O extends Type> extends ArrayList<T> 
        implements Structure<O>, Arithmetic<Arithmetic> {
    
    /**
     * Initializes the structure.
     * @param capacity the initial capacity of the structure.
     */
    public BaseStructure(int capacity) {
        super(capacity);
    }
    
    /**
     * Attempts to add a column to the end of the structure.
     * @param value the column to add, this will be a Vector for a matrix
     * and a Scalar for a Vector.
     * @return the data structure with the newly added column.
     */
    @Override
    public O addColumn(Type value) {
        return this.addColumn(this.getColumnSize(), value);
    }
    
    /**
     * Attempts to add a row to the end of the structure.
     * @param type the row to add, this will be a Vector for a matrix
     * Since a Vector is only a single row, this function is unsupported by Vectors.
     * @return the data structure with the newly added column.
     */
    @Override
    public O addRow(Type type) {
        return this.addRow(this.getRowSize(), type);
    }
    
    /**
     * Gets the row size for the structure. Always returns 1 for a Vector.
     * @return the row size of the data structure.
     */
    public abstract int getRowSize();
    
    /**
     * Gets the column size for the structure.
     * @return the column size of the data structure.
     */
    public abstract int getColumnSize();
    
    /**
     * Attempts a bitwise left operation on each element in the data structure.
     * @param value the parameter for the bitwise left.
     * @return the data structure after the operation has been completed.
     */
    @Override
    public Arithmetic bitwiseLeft(Scalar value) {
        final int n = value.intValueExact();
        Handler h = (Scalar o1, MathContext mc1) -> {
            return new Scalar(o1.movePointLeft(n).doubleValue(), mc1);
        };
        return this.apply(h);
    }
    
    /**
     * Attempts a bitwise right operation on each element in the data structure.
     * @param value the parameter for the bitwise right.
     * @return the data structure after the operation has been completed.
     */
    @Override
    public Arithmetic bitwiseRight(Scalar value) {
        final int n = value.intValueExact();
        Handler h = (Scalar o1, MathContext mc1) -> {
            return new Scalar(o1.movePointRight(n).doubleValue(), mc1);
        };
        return this.apply(h);
    }
    
    /**
     * Attempts to negate all values stored in the data structure.
     * @return the data structure after the operation has been completed.
     */
    @Override
    public Arithmetic neg() {
        return this.apply(Functions.NEGATE);
    }
    
    /**
     * Attempts to convert all values stored in the data structure to a positive value.
     * @return the data structure after the operation has been completed.
     */
    @Override
    public Arithmetic pos() {
        return this.apply(Functions.PLUS);
    }
    
    /**
     * Attempts to convert all values stored in the data structure to its absolute value (disregards sign +/-).
     * @return the data structure after the operation has been completed.
     */
    @Override
    public Arithmetic absolute() {
        return this.apply(Functions.ABS);
    }
    
    /**
     * Attempts to apply a default function to the data structure.
     * @param handle the function to apply.
     * @return the data structure after the operation has been completed.
     */
    @Override
    public Arithmetic apply(Functions handle) {
        return this.apply(handle.get());
    }
    
}
