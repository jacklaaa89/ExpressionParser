package org.expression.structure;

import org.expression.Coordinate;
import org.expression.Type;
import org.expression.structure.function.Function;

/**
 * A interface containing functions applicable to data structures.
 * @author Jack Timblin
 * @param <T> The type of structure to return.
 * @param <F> Type type of function which is applied to this structures elements.
 * @param <E> The entry which this structure accepts when adding columns and rows.
 */
public interface Structure<T extends Type, F extends Function, E extends Type> {
    /**
     * returns a segment of the current structure.
     * @param start the start dimensions of the segment
     * @param end the end dimensions of the segment.
     * @return the segment from the data structure.
     */
    public T slice(Coordinate start, Coordinate end);
    /**
     * Adds a new column to the current structure.
     * All elements are moved up one index from {@code index}
     * instead of overriding the existing column.
     * @param index the index to add the column.
     * @param value the column to add.
     * @return the new structure with the added column.
     */
    public T addColumn(int index, E value);
    /**
     * Adds a new column to the end of the current structure.
     * @param value the column to add.
     * @return the new structure with the added column.
     */
    public T addColumn(E value);
    /**
     * Adds a new row to the current structure.
     * All elements are moved up one index from {@code index}
     * instead of overriding the existing row.
     * @param index the index to add the row.
     * @param type the row to add.
     * @return the new structure with the added row.
     */
    public T addRow(int index, E type);
    /**
     * Adds a new row to the end of the current structure.
     * @param type the row to add.
     * @return the new structure with the added row.
     */
    public T addRow(E type);
    /**
     * Swaps row {@code i} with row {@code j}.
     * @param i the index of row i.
     * @param j the index of row j.
     */
    public void swap(int i, int j);
    /**
     * Attempts to make a shallow copy of this data structure.
     * @return the copy of this data structure.
     */
    public T copy();
    /**
     * Applies a function to a particular coordinate in the data structure.
     * @param i the coordinate to apply the function.
     * @param function the function to apply.
     */
    public void updateAt(Coordinate i, F function);
}
