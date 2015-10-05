package org.expression;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A complete implementation of a Vector.
 * A Vector is described as a list with a capped limit which can 
 * have arithmetic applied to it. 
 * i.e A + B = C where A and B are both Vectors or the same length.
 * 
 * This class also has implementations so that logical expressions can be
 * used on Vectors. i.e A == B or A >= B.
 * @author Jack Timblin
 */
public class Vector extends ArrayList<Scalar>
        implements Arithmetic, Structure<Vector> {
    
    /**
     * the maximum amount of elements this Vector can have.
     */
    private final int limit;
    
    /**
     * The MathContext to apply to elements and computations in this Vector.
     */
    private final MathContext mc;
    
    /**
     * Initializes a Vector of a given size.
     * @param capacity the maximum size of this Vector.
     * @param context a given MathContext to use in computation.
     */
    public Vector(int capacity, MathContext context) {
        super(capacity);
        this.limit = capacity;
        for(int i = 0; i < limit; i++) {
            this.add(i, new Scalar(0d));
        }
        this.mc = context;
    }
    
    /**
     * Initializes a Vector of a given size.
     * @param capacity the maximum size of this Vector.
     */
    public Vector(int capacity) {
        this(capacity, MathContext.DECIMAL32);
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
    public Scalar set(int index, Scalar item) {
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
        hash = 17 * hash + Objects.hashCode(this.mc);
        return hash;
    }
    
    /**
     * Generates a Vector with all zero values, using a DECIMAL32
     * MathContext.
     * @param n the size of the vector.
     * @return the generated vector
     */
    public static Vector zeroes(int n) {
        return Vector.zeroes(n, MathContext.DECIMAL32);
    }
    
    /**
     * Generates a Vector with all zero values, using a provided
     * MathContext.
     * @param n the size of the vector.
     * @param context the provided math context to use.
     * @return the generated vector
     */
    public static Vector zeroes(int n, MathContext context) {
        Vector v = new Vector(n, context);
        return v;
    }
    
    /**
     * Generates a Vector with all random values between 0 and 1,
     * using a provided MathContext.
     * @param n the size of the vector.
     * @param context the provided math context to use.
     * @return the generated vector
     */
    public static Vector random(int n, MathContext context) {
        Vector v = new Vector(n, context);
        for(int i = 0; i < n; i++) {
            v.set(i, new Scalar(Math.random(), context));
        }
        return v;
    }
    
    /**
     * Generates a Vector with all random values between 0 and 1,
     * using a DECIMAL32 MathContext.
     * @param n the size of the vector.
     * @return the generated vector
     */
    public static Vector random(int n) {
        return Vector.random(n, MathContext.DECIMAL32);
    }
    
    /**
     * Attempts to compute A + B = C
     * @param B the vector to add to this vector.
     * @return the computed vector of A + B = C
     * @throws ArithmeticException if the vectors lengths are not the same.
     */
    @Override
    public Arithmetic plus(Type B) throws ArithmeticException {
        if(B instanceof Scalar) return this.plus((Scalar)B);
        Vector A = this;
        Vector b = (Vector) B;
        int N = this.size();
        int BN = b.size();
        if(N != BN) throw new ArithmeticException("Columns have to be same size.");
        Vector C = new Vector(N);
        for(int i = 0; i < N; i++) {
            BigDecimal v = A.get(i).add(b.get(i), mc);
            Scalar n = new Scalar(v.doubleValue());
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
            BigDecimal v = A.get(i).add(augend, mc);
            Scalar n = new Scalar(v.doubleValue());
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
        if(divisor.equals(BigDecimal.ZERO)) throw new ArithmeticException("division by zero.");
        Vector A = this;
        int N = this.size();
        Vector C = new Vector(N);
        for(int i = 0; i < N; i++) {
            BigDecimal v = A.get(i).divide(divisor, mc);
            Scalar n = new Scalar(v.doubleValue());
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
    public Arithmetic divide(Type B) throws ArithmeticException {
        if(B instanceof Scalar) return this.divide((Scalar)B);
        Vector A = this;
        Vector b = (Vector) B;
        int N = this.size();
        int BN = b.size();
        if(N != BN) throw new ArithmeticException("Columns have to be same size.");
        Vector C = new Vector(N);
        for(int i = 0; i < N; i++) {
            BigDecimal bi = b.get(i);
            if(bi.equals(BigDecimal.ZERO)) throw new ArithmeticException("division by zero.");
            BigDecimal v = A.get(i).divide(bi, mc);
            Scalar n = new Scalar(v.doubleValue());
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
            BigDecimal v = A.get(i).subtract(subtrahend, mc);
            Scalar n = new Scalar(v.doubleValue());
            C.set(i, n);
        }
        return C;
    }
    
    @Override
    public Arithmetic minus(Type B) {
        if(B instanceof Scalar) return this.minus((Scalar)B);
        Vector A = this;
        Vector b = (Vector) B;
        int N = this.size();
        int BN = b.size();
        if(N != BN) throw new RuntimeException("Columns have to be same size.");
        Vector C = new Vector(N);
        for(int i = 0; i < N; i++) {
            BigDecimal v = A.get(i).subtract(b.get(i), mc);
            Scalar n = new Scalar(v.doubleValue());
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
            BigDecimal v = A.get(i).multiply(multiplicand, mc);
            Scalar n = new Scalar(v.doubleValue());
            C.set(i, n);
        }
        return C;
    }
    
    @Override
    public Arithmetic multiply(Type B) {
        if(B instanceof Scalar) return this.multiply((Scalar)B);
        Vector A = this;
        Vector b = (Vector) B;
        int N = this.size();
        int BN = b.size();
        if(N != BN) throw new RuntimeException("Columns have to be same size.");
        Vector C = new Vector(N);
        for(int i = 0; i < N; i++) {
            BigDecimal v = A.get(i).multiply(b.get(i), mc);
            Scalar n = new Scalar(v.doubleValue());
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
            BigDecimal v = A.get(i).multiply(B.get(i), mc);
            BigDecimal de = d.add(v, mc);
            d = new Scalar(de.doubleValue());
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
    public int compareTo(Type O) {
        
        if(!(O instanceof Vector)) throw new RuntimeException("can only compare a vector to a vector.");
        
        Vector o = (Vector) O;
        if(this.size() != o.size()) throw new RuntimeException("Vectors must be the same size");
        
        if(this.equals(o)) return 0;
        
        HashMap<Integer, Integer> in = new HashMap<>();
        //run compareTo on the values in the vector.
        for(int i = 0; i < this.size(); i++) {
            int e = this.get(i).compareTo((Type)o.get(i));
            if(e != 0) {
                if(!in.containsKey(e)) {
                    in.put(e, 0);
                }
                int ei = in.get(e);
                ei++;
                in.put(e, ei);
            }
        }
        
        List<Map.Entry<Integer, Integer>> list = new LinkedList(in.entrySet());
        Collections.sort(list, (Object o1, Object o2) -> {
            Map.Entry<Integer, Integer> e1 = (Map.Entry) o1;
            Map.Entry<Integer, Integer> e2 = (Map.Entry) o2;
            return e2.getValue().compareTo(e1.getValue());
        });
        
        return list.get(0).getKey();
        
    }

    @Override
    public boolean sizeOf(Object object) {
        if(!(object instanceof Vector)) return false;
        Vector v = (Vector) object;         
        return this.size() == v.size();
    }

    @Override
    public Arithmetic remainder(Type data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Scalar sum() {
        Scalar t = Scalar.ZERO;
        for(int i = 0; i < this.size(); i++) {
            BigDecimal d = t.add(this.get(i), mc);
            t = new Scalar(d.doubleValue(), mc);
        }
        return t;
    }

    @Override
    public Vector apply(Handler handler) {
        Vector A = this;
        Vector C = new Vector(A.size());
        for(int i = 0; i < this.size(); i++) {
            Scalar item = handler.handle(A.get(i), mc);
            C.set(i, item);
        }
        return C;
    }

    @Override
    public Type apply(Functions handle) {
        return this.apply(handle.get());
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
    public Vector addColumn(int index, Type value) {
        if(index < 0 || index > this.size()) throw new ArrayIndexOutOfBoundsException("invalid index");
        if(!(value instanceof Scalar)) throw new IllegalArgumentException("can only add scalars to vectors");
        Scalar[] sn = this.toArray(new Scalar[]{});
        Scalar[] dn = new Scalar[sn.length + 1];
        System.arraycopy(sn, index, dn, index + 1, sn.length - index);
        dn[index] = (Scalar) value;
        for(int i = 0; i < index; i++) {
            dn[i] = sn[i];
        }
        return new Vector(dn);
    }
    
     @Override
    public Vector addColumn(Type value) {
        return this.addColumn(this.size(), value);
    }

    @Override
    public Vector addRow(int index, Type type) {
        throw new ArithmeticException("Vectors are only one row.");
    }

    @Override
    public Vector addRow(Type type) {
        throw new ArithmeticException("Vectors are only one row.");
    }

    @Override
    public Arithmetic bitwiseLeft(Scalar value) {
        final int n = value.intValueExact();
        Handler h = (Scalar o1, MathContext mc1) -> {
            return new Scalar(o1.movePointLeft(n).doubleValue(), mc1);
        };
        return this.apply(h);
    }

    @Override
    public Arithmetic bitwiseRight(Scalar value) {
        final int n = value.intValueExact();
        Handler h = (Scalar o1, MathContext mc1) -> {
            return new Scalar(o1.movePointRight(n).doubleValue(), mc1);
        };
        return this.apply(h);
    }
    
    @Override
    public Arithmetic neg() {
        Handler h = (Scalar o1, MathContext mc1) -> {
            return (Scalar) o1.neg();
        };
        return this.apply(h);
    }
    
    @Override
    public Arithmetic pos() {
        Handler h = (Scalar o1, MathContext mc1) -> {
            return (Scalar) o1.pos();
        };
        return this.apply(h);
    }

    @Override
    public Arithmetic absolute() {
        Handler h = (Scalar o1, MathContext mc1) -> {
            return (Scalar) o1.absolute();
        };
        return this.apply(h);
    }
    
    @Override
    public Arithmetic strip() {
        Handler h = (Scalar o1, MathContext mc1) -> {
            return (Scalar) o1.strip();
        };
        return this.apply(h);
    }
    
}
