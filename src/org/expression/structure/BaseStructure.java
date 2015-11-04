package org.expression.structure;

import java.util.ArrayList;
import org.expression.computation.Arithmetic;
import org.expression.computation.Functions;
import org.expression.computation.Handler;
import org.expression.Scalar;
import org.expression.Type;
import org.expression.structure.function.Function;

/**
 * Data structure base class, It gives data structures some generic methods and initialization.
 * @author Jack Timblin
 * @param <T> The value that this structure holds.
 * @param <O> The type of Object that will be returned when manipulating the structure.
 * @param <F> The type of Function this Structure will apply to its elements.
 */
public abstract class BaseStructure<T extends Type, O extends Type, F extends Function> extends ArrayList<T> 
        implements Structure<O, F, T>, Arithmetic<Arithmetic> {
    
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
    public O addColumn(T value) {
        return this.addColumn(this.getColumnSize(), value);
    }
    
    /**
     * Attempts to add a row to the end of the structure.
     * @param type the row to add, this will be a Vector for a matrix
     * Since a Vector is only a single row, this function is unsupported by Vectors.
     * @return the data structure with the newly added column.
     */
    @Override
    public O addRow(T type) {
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
        Handler h = (Scalar o1) -> {
            return (Scalar) o1.bitwiseLeft(value);
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
        Handler h = (Scalar o1) -> {
            return (Scalar) o1.bitwiseRight(value);
        };
        return this.apply(h);
    }
    
    /**
     * Attempts to negate all values stored in the data structure.
     * @return the data structure after the operation has been completed.
     */
    @Override
    public Arithmetic negate() {
        return this.apply(Functions.NEGATE);
    }
    
    /**
     * Attempts to convert all values stored in the data structure to a positive value.
     * @return the data structure after the operation has been completed.
     */
    @Override
    public Arithmetic plus() {
        return this.apply(Functions.PLUS);
    }
    
    /**
     * Attempts to convert all values stored in the data structure to its absolute value (disregards sign +/-).
     * @return the data structure after the operation has been completed.
     */
    @Override
    public Arithmetic abs() {
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
    
    @Override
    public int compareTo(Arithmetic O) {
        if(!this.sizeOf(O)) throw new ArithmeticException("structures need to have the same dimensions.");
        if(this.equals(O)) return 0;
        return this.sum().compareTo(O.sum());
    }
    
}
