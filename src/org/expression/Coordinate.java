package org.expression;

import org.expression.structure.Vector;

/**
 * A typical point with an x and y value, used to determine a point in a data structure.
 * @author Jack Timblin
 */
public class Coordinate implements Comparable<Coordinate> {
    
    /**
     * The X coordinate.
     */
    public int x;
    
    /**
     * The Y coordinate.
     */
    public int y;
    
    /**
     * A Coordinate to signify the start of the data structure.
     */
    public static final Coordinate COORDINATE_START = new Coordinate(0,0); //data structure indexes start from 0.
    
    /**
     * A Coordinate to signify the end of a data structure.
     */
    public static final Coordinate COORDINATE_END = new Coordinate(Integer.MAX_VALUE, Integer.MAX_VALUE);
    
    /**
     * Initializes a new Coordinate with 0 x and y values.
     */
    public Coordinate() {
        this.x = 0;
        this.y = 0;
    }
    
    /**
     * Initializes a Coordinate from a single Scalar value.
     * @param x the scalar value.
     */
    public Coordinate(Scalar x) {
        this(x.intValue());
    } 
    
    /**
     * Initializes a Coordinate from a Vector or Scalars.
     * @param xy the vector to use.
     */
    public Coordinate(Vector xy) {
        this();
        if(xy.size() < 1) {
            throw new RuntimeException("not enough values provided");
        }
        this.x = xy.get(0).intValue();
        if(xy.size() > 1) {
            this.y = xy.get(1).intValue();
        }
    }
    
    /**
     * Initializes a new Coordinate with just an X value.
     * @param x the x value.
     */
    public Coordinate(int x) {
        this();
        this.x = x;
    }
    
    /**
     * Initializes a new Coordinate with an X and Y value.
     * @param x the x value
     * @param y the y value
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Coordinate)) return false;
        Coordinate B = (Coordinate) o;
        return this.x == B.x && this.y == B.y;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.x;
        hash = 67 * hash + this.y;
        return hash;
    }

    @Override
    public int compareTo(Coordinate o) {
        if(this.equals(o)) return 0;
        if(this.x > o.x) {
            return 1;
        }
        if(this.x < o.x) {
            return -1;
        }
        return this.y > o.y ? 1 : -1;
    }
    
}
