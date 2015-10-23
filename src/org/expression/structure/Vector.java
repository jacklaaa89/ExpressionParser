package org.expression.structure;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import org.expression.computation.Arithmetic;
import org.expression.Coordinate;
import org.expression.computation.Handler;
import org.expression.Scalar;
import org.expression.Type;
import org.expression.structure.function.VectorFunction;
import org.expression.structure.function.Vectors;

/**
 * A complete implementation of a Vector.
 * A Vector is described as a list with a capped limit which can 
 * have arithmetic applied to it. 
 * i.e A + B = C where A and B are both Vectors or the same length.
 * 
 * This class also has implementations so that logical expressions can be
 * used on Vectors.
 * @author Jack Timblin
 */
public class Vector extends BaseStructure<Scalar, Vector, VectorFunction> {
    
    /**
     * the maximum amount of elements this Vector can have.
     */
    private final int limit;
    
    /**
     * Initializes a Vector of a given size.
     * @param capacity the maximum size of this Vector.
     */
    public Vector(int capacity) {
        super(capacity);
        this.limit = capacity;
        for(int i = 0; i < limit; i++) {
            this.add(i, new Scalar(0d));
        }
    }
    
    public Vector(Scalar[] data) {
        this(data.length);
        for(int i = 0; i < data.length; i++) {
            this.set(i, data[i]);
        }
    }
    
    public Vector(double[] data) {
        this(data.length);
        for(int i = 0; i < data.length; i++) {
            this.set(i, new Scalar(data[i]));
        }
    }
    
    /**
     * returns the maximum capacity of this Vector.
     * @return the maximum capacity of this vector.
     */
    public int getLimit() {
        return this.limit;
    }
    
    /**
     * Adds an item to the end of the Vector, up to 
     * the Vectors maximum capacity.
     * @param item the item to add to the Vector.
     * @return true if the item was added, false otherwise.
     */
    @Override
    public final boolean add(Scalar item) {
        if(this.size() < limit) {
            return super.add(item);
        }
        return false;
    }
    
    /**
     * Attempts to add an item at a specific index.
     * @param index the index to add the item.
     * @param item the item to add.
     */
    @Override
    public final void add(int index, Scalar item) {
        if(this.size() >= limit) {
            return;
        }
        super.add(index, item);
    }
    
    /**
     * Attempts to set an item at a particular index.
     * @param index the index to set the item
     * @param item the item to set
     * @return the previously set item.
     */
    @Override
    public final Scalar set(int index, Scalar item) {
        if(index < limit) {
            return super.set(index, item);
        }
        return null;
    }
    
    /**
     * Attempts to add a collection of items to the Vector
     * if adding the full collection would exceed the limit
     * none of the items are added.
     * @param c the collection to add to the Vector, items are added
     * in the order they are retrieved from the collections iterator.
     * @return true if the collection was added, false otherwise.
     */
    @Override
    public boolean addAll(Collection c) {
        if((this.size() + c.size()) >= limit) {
            return false;
        }
        return super.addAll(c);
    }
    
    /**
     * Attempts to add a collection of items to the Vector
     * at a particular index
     * if adding the full collection would exceed the limit
     * none of the items are added.
     * @param index the index to start adding the collection
     * @param c the collection to add to the Vector, items are added
     * in the order they are retrieved from the collections iterator.
     * @return true if the collection was added, false otherwise.
     */
    @Override
    public boolean addAll(int index, Collection c) {
        if((this.size() + c.size()) >= limit) {
            return false;
        }
        return super.addAll(index, c);
    }
    
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Vector)) { return false; }
        Vector v = (Vector) o;
        if(v.getLimit() != this.getLimit()) { return false; }
        if(v.size() != this.size()) { return false; }
        for(int i = 0; i < this.size(); i++) {
            if(!this.get(i).equals(v.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.limit;
        return hash;
    }
    
    /**
     * Generates a Vector with all zero values.
     * @param n the size of the vector.
     * @return the generated vector
     */
    public static Vector zeroes(int n) {
        Vector v = new Vector(n);
        return v;
    }
    
    /**
     * Generates a Vector with all zero values.
     * @param n the size of the vector.
     * @return the generated vector
     */
    public static Vector zeroes(Scalar n) {
        return Vector.random(n.intValue());
    }
    
    /**
     * Generates a Vector with all random values between 0 and 1.
     * @param n the size of the vector.
     * @return the generated vector
     */
    public static Vector random(int n) {
        Vector v = new Vector(n);
        for(int i = 0; i < n; i++) {
            v.set(i, new Scalar(Math.random()));
        }
        return v;
    }
    
    /**
     * Generates a Vector with all random values between 0 and 1.
     * @param n the size of the vector.
     * @return the generated vector
     */
    public static Vector random(Scalar n) {
        return Vector.random(n.intValue());
    }
    
    /**
     * Attempts to compute A + B = C
     * @param B the vector to add to this vector.
     * @return the computed vector of A + B = C
     * @throws ArithmeticException if the vectors lengths are not the same.
     */
    @Override
    public Vector add(Type B) throws ArithmeticException {
        if(B instanceof Scalar) return this.plus((Scalar)B);
        Vector A = this;
        Vector b = (Vector) B;
        int N = this.size();
        int BN = b.size();
        if(N != BN) throw new ArithmeticException("Columns have to be same size.");
        Vector C = new Vector(N);
        for(int i = 0; i < N; i++) {
            Scalar n = (Scalar) A.get(i).add(b.get(i));
            C.set(i, n);
        }
        return C;
    }
    
    /**
     * Attempts to add a scalar value to each element in the Vector.
     * i.e A + b = C
     * @param augend the scalar value to add.
     * @return the computed result of A + b = C
     */
    public Vector plus(Scalar augend) {
        Vector A = this;
        int N = this.size();
        Vector C = new Vector(N);
        for(int i = 0; i < N; i++) {
            Scalar n = (Scalar) A.get(i).add(augend);
            C.set(i, n);
        }
        return C;
    }
    
    /**
     * Attempts to divide each value in this Vector by a scalar value.
     * @param divisor the scalar value to divide each element in the vector with.
     * @return the result of A/b = C
     * @throws ArithmeticException if a division by zero is attempted.
     */
    public Vector divide(Scalar divisor) throws ArithmeticException {
        if(divisor.equals(Scalar.ZERO)) throw new ArithmeticException("division by zero.");
        Vector A = this;
        int N = this.size();
        Vector C = new Vector(N);
        for(int i = 0; i < N; i++) {
            Scalar n = (Scalar) A.get(i).divide(divisor);
            C.set(i, n);
        }
        return C;
    }
    
    /**
     * Attempts to compute A/B = C where each element is divided by the
     * corresponding element in B to produce C.
     * @param B the vector to compute A/B = C with.
     * @return the computed Vector.
     * @throws ArithmeticException if the Vectors sizes don't match or a division by zero 
     * is attempted.
     */
    @Override
    public Vector divide(Type B) throws ArithmeticException {
        if(B instanceof Scalar) return this.divide((Scalar)B);
        Vector A = this;
        Vector b = (Vector) B;
        int N = this.size();
        int BN = b.size();
        if(N != BN) throw new ArithmeticException("Columns have to be same size.");
        Vector C = new Vector(N);
        for(int i = 0; i < N; i++) {
            Scalar bi = b.get(i);
            if(bi.equals(Scalar.ZERO)) throw new ArithmeticException("division by zero.");
            Scalar n = (Scalar) A.get(i).divide(bi);
            C.set(i, n);
        }
        return C;
    }
    
    /**
     * Attempts A-b = C where b is a scalar value.
     * @param subtrahend the scalar value
     * @return the result of A-b = C 
     */
    public Vector minus(Scalar subtrahend) {
        Vector A = this;
        int N = this.size();
        Vector C = new Vector(N);
        for(int i = 0; i < N; i++) {
            Scalar n = (Scalar) A.get(i).subtract(subtrahend);
            C.set(i, n);
        }
        return C;
    }
    
    @Override
    public Vector subtract(Type B) {
        if(B instanceof Scalar) return this.minus((Scalar)B);
        Vector A = this;
        Vector b = (Vector) B;
        int N = this.size();
        int BN = b.size();
        if(N != BN) throw new RuntimeException("Columns have to be same size.");
        Vector C = new Vector(N);
        for(int i = 0; i < N; i++) {
            Scalar n = (Scalar) A.get(i).subtract(b.get(i));
            C.set(i, n);
        }
        return C;
    }
    
    @Override
    public Scalar max() {
        return Collections.max(this);
    }
    
    @Override
    public Scalar min() {
        return Collections.min(this);
    }
    
    /**
     * Attempts to perform Ab = C where b is a scalar value.
     * @param multiplicand the scalar value.
     * @return the result of Ab = C.
     */
    public Vector multiply(Scalar multiplicand) {
        Vector A = this;
        int N = this.size();
        Vector C = new Vector(N);
        for(int i = 0; i < N; i++) {
            Scalar n = (Scalar) A.get(i).multiply(multiplicand);
            C.set(i, n);
        }
        return C;
    }
    
    @Override
    public Vector multiply(Type B) {
        if(B instanceof Scalar) return this.multiply((Scalar)B);
        Vector A = this;
        Vector b = (Vector) B;
        int N = this.size();
        int BN = b.size();
        if(N != BN) throw new RuntimeException("Columns have to be same size.");
        Vector C = new Vector(N);
        for(int i = 0; i < N; i++) {
            Scalar n = (Scalar) A.get(i).multiply(b.get(i));
            C.set(i, n);
        }
        return C;
    }
    
    /**
     * Attempts to compute the Vector inner product for this Vector.
     * i.e A.B = c where c is a scalar value.
     * @param B the vector to compute with.
     * @return the result of A.B = c
     */
    public Scalar dot(Vector B) {
        Vector A = this;
        int N = this.size();
        int BN = B.size();
        if(N != BN) throw new RuntimeException("Columns have to be same size.");
        Scalar d = new Scalar(0d);
        for(int i = 0; i < N; i++) {
            Scalar v = (Scalar) A.get(i).multiply(B.get(i));
            d = (Scalar) d.add(v);
        }
        
        return d;
        
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i = 0; i < this.size(); i++) {
            builder.append(this.get(i));
            if((i + 1) != this.size()) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public boolean sizeOf(Object object) {
        if(!(object instanceof Vector)) return false;
        Vector v = (Vector) object;         
        return this.size() == v.size();
    }

    @Override
    public Arithmetic remainder(Type data) {
        Handler h = (Handler) (Scalar o1) -> {
            return (Scalar) o1.remainder(data);
        };
        return this.apply(h);
    }
    
    @Override
    public Scalar sum() {
        Scalar t = Scalar.ZERO;
        for (Scalar aThi : this) {
            t = (Scalar) aThi.add(t);
        }
        return t;
    }

    @Override
    public Vector apply(Handler handler) {
        Vector A = this;
        Vector C = new Vector(A.size());
        for(int i = 0; i < this.size(); i++) {
            Scalar item = handler.handle(A.get(i));
            C.set(i, item);
        }
        return C;
    }

    @Override
    public Vector slice(Coordinate start, Coordinate end) {
        //sanity checking.
        //check that the start is not larger than the end.
        if(start.compareTo(end) == 1) throw new ArithmeticException("start cannot be larger than the end.");
        
        if(start.equals(Coordinate.COORDINATE_START)) start.x = 0;
        if(end.equals(Coordinate.COORDINATE_END)) end.x = (this.size() - 1);
        
        //if the dimensions fit in the existing vector.
        if(start.x < 0 || end.x > this.size()) {
            throw new ArithmeticException("coordinates do not fit in the current data structure");
        }
        int size = (end.x - start.x) + 1;
        Vector v = new Vector(size);
        for(int i = 0; i < v.size(); i++) {
            v.set(i, this.get(start.x + i));
        }
        return v;
    }

    @Override
    public Vector addColumn(int index, Scalar value) {
        if(index < 0 || index > this.size()) throw new ArrayIndexOutOfBoundsException("invalid index");
        Scalar[] sn = this.toArray(new Scalar[]{});
        Vector ds = new Vector(new Scalar[]{(Scalar)value});
        Scalar[] dn = new Scalar[sn.length + ds.size()];
        System.arraycopy(sn, index, dn, index + ds.size(), dn.length - sn.length);
        for(int i = 0; i < ds.size(); i++) {
            dn[index + i] = ds.get(i);
        }
        System.arraycopy(sn, 0, dn, 0, index);
        return new Vector(dn);
    }

    @Override
    public Vector addRow(int index, Scalar type) {
        throw new ArithmeticException("Vectors are only one row.");
    }

    @Override
    public int getRowSize() {
        return 1; //vectors are always one row.
    }

    @Override
    public int getColumnSize() {
        return this.size();
    }
    
    @Override
    public void swap(int i, int j) {
        Scalar temp = this.get(i);
        this.set(i, this.get(j));
        this.set(j, temp);
    }
    
    @Override
    public Vector copy() {
        Vector v = new Vector(this.size());
        for(int i = 0; i < this.size(); i++) {
            v.set(i, this.get(i));
        }
        return v;
    }
    
    /**
     * Updates a value in this vector using a VectorFunction.
     * @param n the index.
     * @param v the function to apply at the row/index.
     */
    @Override
    public void updateAt(Coordinate n, VectorFunction v) {
        int i = n.x;
        set(i, v.evaluate(i, get(i)));
    }

    @Override
    public Vector increment() {
        Vector A = this.copy();
        for(int i = 0; i < A.size(); i++) {
            A.updateAt(new Coordinate(i), Vectors.INCREMENT());
        }
        return A;
    }

    @Override
    public Vector decrement() {
        Vector A = this.copy();
        for(int i = 0; i < A.size(); i++) {
            A.updateAt(new Coordinate(i), Vectors.DECREMENT());
        }
        return A;
    }
    
}
