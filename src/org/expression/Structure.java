package org.expression;

/**
 *
 * @author jacktimblin
 */
public interface Structure<T extends Type> {
    /**
     * returns a segment of the current structure.
     * @param start the start dimensions of the segment
     * @param end the end dimensions of the segment.
     * @return the segment from the data structure.
     */
    public T slice(Coordinate start, Coordinate end);
}
