package org.expression.structure;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.expression.computation.Arithmetic;
import org.expression.Coordinate;
import org.expression.computation.Functions;
import org.expression.computation.Handler;
import org.expression.Scalar;
import org.expression.Type;
import org.expression.computation.decomposition.AbstractDecompositor;
import org.expression.computation.decomposition.LUDecompositor;
import org.expression.computation.decomposition.LinearSystemDecompositor;
import org.expression.computation.decomposition.SingleValueDecomposition;
import org.expression.computation.inverse.AbstractInverter;
import org.expression.computation.inverse.LinearSystemInverter;
import org.expression.computation.linear.AbstractSolver;
import org.expression.computation.linear.LinearSystemSolver;

/**
 * A representation of a Matrix.
 * @author Jack Timblin
 */
public class Matrix extends BaseStructure<Vector, Matrix> {
    
    /**
     * the row size of this matrix
     */
    private final int M;
    
    /**
     * the column size in this matrix
     */
    private final int N;
    
    /**
     * An instance of a MathContext to use in computation.
     */
    private final MathContext mc;
    
    /**
     * Initializes an empty matrix with zero values.
     * @param m the column size
     * @param n the row size.
     * @param mc A MathContext to use in computation.
     */
    public Matrix(int m, int n, MathContext mc) {
        super(m); //set the row capacity.
        this.M = m;
        this.N = n;
        this.mc = mc;
        for(int i = 0; i < m; i++) {
            Vector v = Vector.zeroes(n, mc);
            this.add(v);
        }
    }
    
    /**
     * Initializes a new Matrix with zero values, 
     * using a DECIMAL32 MathContext
     * @param m the column size
     * @param n the row size.
     */
    public Matrix(int m, int n) {
        this(m, n, MathContext.DECIMAL32);
    }
    
    /**
     * Initializes a Matrix from a list of Vectors.
     * @param columns the list of vectors.
     * @param mc a MathContext to use in computation.
     */
    public Matrix(List<Vector> columns, MathContext mc) {
        super(columns.size());
        int i = 0; boolean first = true;
        if(columns.isEmpty()) {
            throw new ArithmeticException("need at least one column");
        }
        
        int size = columns.get(0).size();
        this.M = columns.size();
        this.N = size;
        this.mc = mc;
        for(int j = 0; j < columns.size(); j++) {
            Vector e = columns.get(j);
            if(!first) {
                if(e.size() != i) throw new ArithmeticException("invalid column length");
            }
            i = e.size();
            first = false;
            this.add(e);
        }
    }
    
    /**
     * Initializes a Matrix from a list of Vectors,
     * using a DECIMAL32 MathContext.
     * @param columns the list of Vectors.
     */
    public Matrix(List<Vector> columns) {
        this(columns, MathContext.DECIMAL32);
    }
    
    /**
     * Initializes a Matrix from a 2D array of Scalar values, 
     * using a DECIMAL32 MathContext.
     * @param data the data to populate the Matrix with.
     */
    public Matrix(Scalar[][] data) {
        this(data, MathContext.DECIMAL32);
    }
    
    /**
     * Initializes a matrix from a 2d array.
     * @param data the array to copy data from.
     * @param mc the MathContext to use in computation.
     */
    public Matrix(Scalar[][] data, MathContext mc) {
        super(data.length);
        if(data.length == 0) {
            throw new ArithmeticException("invalid amount of rows");
        }
        M = data.length;
        N = data[0].length;
        this.mc = mc;
        for(int i = 0; i < M; i++) {
            Vector v = Vector.zeroes(N);
            for(int j = 0; j < N; j++) {
                v.set(j, data[i][j]);
            }
            this.add(v);
        }
    }
    
    /**
     * Initializes a Matrix from a 2D array of double values.
     * @param data the 2D array of double values.
     * @param mc the MathContext to use in the computation.
     */
    public Matrix(double[][] data, MathContext mc) {
        super(data.length);
        M = data.length;
        N = data[0].length;
        this.mc = mc;
        for(int i = 0; i < M; i++) {
            Vector v = Vector.zeroes(N);
            for(int j = 0; j < N; j++) {
                v.set(j, new Scalar(data[i][j]));
            }
            this.add(v);
        }
    }
    
    /**
     * Initializes a Matrix from a 2D array of double values, 
     * using a DECIMAL32 MathContext.
     * @param data the 2D array of double values.
     */
    public Matrix(double[][] data) {
        this(data, MathContext.DECIMAL32);
    }
    
    /**
     * Initializes an Matrix with zero values with the same
     * dimensions as Matrix A.
     * @param A the matrix to provide a zero value Matrix from.
     * @param mc the MathContext to use in the computation.
     * @return A new zero value Matrix with the same dimensions as A.
     */
    public static Matrix from(Matrix A, MathContext mc) {
        return Matrix.zeroes(A.M, A.N, mc);
    }
    
    /**
     * Initializes an Matrix with zero values with the same
     * dimensions as Matrix A, using a DECIMAL32 MathContext.
     * @param A the matrix to provide a zero value Matrix from.
     * @return A new zero value Matrix with the same dimensions as A.
     */
    public static Matrix from(Matrix A) {
        return Matrix.zeroes(A.M, A.N, MathContext.DECIMAL32);
    }
    
    /**
     * generates a M-by-N matrix with random values between 0 and 1.
     * @param m the column size
     * @param n the row size.
     * @param mc the MathContext to use in computation.
     * @return the matrix with m,n random values.
     */
    public static Matrix random(int m, int n, MathContext mc) {
        Matrix C = new Matrix(m, n, mc);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
               C.set(i, j, new Scalar(Math.random()));
            }
        }
        return C;
    }
    
    public static Matrix random(Scalar m, Scalar n, MathContext mc) {
        return Matrix.random(m.intValue(), n.intValue(), mc);
    }
    
    public static Matrix random(Scalar m, Scalar n) {
        return Matrix.random(m.intValue(), n.intValue());
    }
    
    public static Matrix random(Scalar n) {
        return Matrix.random(n.intValue());
    }
    
    /**
     * generates a M-by-N matrix with random values between 0 and 1,
     * using a DECIMAL32 MathContext.
     * @param m the column size
     * @param n the row size.
     * @return the matrix with m,n random values.
     */
    public static Matrix random(int m, int n) {
        return Matrix.random(m, n, MathContext.DECIMAL32);
    }
    
    /**
     * generates a M-by-M square matrix with random values between 0 and 1.
     * @param n the column and row size.
     * @param mc the MathContext to use in computation.
     * @return the matrix with m,n random values.
     */
    public static Matrix random(int n, MathContext mc) {
        return Matrix.random(n, n, mc);
    }
    
    /**
     * generates a M-by-M square matrix with random values between 0 and 1,
     * using a DECIMAL32 MathContext.
     * @param n the column and row size.
     * @return the matrix with m,n random values.
     */
    public static Matrix random(int n) {
        return Matrix.random(n, MathContext.DECIMAL32);
    }
    
    /**
     * generates a new M-by-N matrix full of zero values.
     * @param m the column size
     * @param n the row size.
     * @param mc the MathContext to use in computation.
     * @return the matrix with m,n zeroes.
     */
    public static Matrix zeroes(int m, int n, MathContext mc) {
        Matrix C = new Matrix(m, n, mc);
        return C;
    }
    
    public static Matrix zeroes(Scalar m, Scalar n, MathContext mc) {
        return Matrix.zeroes(m.intValue(), n.intValue(), mc);
    }
    
    public static Matrix zeroes(Scalar m, Scalar n) {
        return Matrix.zeroes(m.intValue(), n.intValue());
    }
    
    public static Matrix zeroes(Scalar m) {
        return Matrix.zeroes(m.intValue());
    }
    
    /**
     * generates a new M-by-N matrix full of zero values,
     * using a DECIMAL32 MathContext.
     * @param m the column size
     * @param n the row size.
     * @return the matrix with m,n zeroes.
     */
    public static Matrix zeroes(int m, int n) {
        return Matrix.zeroes(m, n, MathContext.DECIMAL32);
    }
    
    /**
     * generates a new square matrix full of zero values.
     * @param n the column and row size.
     * @param mc the MathContext to use in computation.
     * @return the matrix with n,n zeroes.
     */
    public static Matrix zeroes(int n, MathContext mc) {
        return Matrix.zeroes(n, n, mc);
    }
    
    /**
     * generates a new square matrix full of zero values,
     * using a DECIMAL32 MathContext.
     * @param n the column and row size.
     * @return the matrix with n,n zeroes.
     */
    public static Matrix zeroes(int n) {
        return Matrix.zeroes(n, MathContext.DECIMAL32);
    }
    
    /**
     * generates a N-by-N identity matrix,
     * using a DECIMAL32 MathContext.
     * @param n the size matrix to generate.
     * @return the generated identity matrix.
     */
    public static Matrix identity(int n) {
        return Matrix.identity(n, MathContext.DECIMAL32);
    }
    
    /**
     * generates a N-by-N identity matrix.
     * @param n the size matrix to generate.
     * @param mc a MathContext to use in computation.
     * @return the generated identity matrix.
     */
    public static Matrix identity(int n, MathContext mc) {
        Matrix C = new Matrix(n, n, mc);
        for(int i = 0; i < n; i++)
            C.set(i, i, new Scalar(1d));
        return C;
    }
    
    /**
     * Generates a square scalar matrix with a particular scalar value 
     * down the diagonal, using a DECIMAL32 MathContext.
     * @param n the column and row size.
     * @param scalar the scalar value to put down the diagonal.
     * @return the generated scalar matrix.
     */
    public static  Matrix scalar(int n, Scalar scalar) {
        return Matrix.scalar(n, scalar, MathContext.DECIMAL32);
    }
    
    /**
     * Generates a square scalar matrix with a particular scalar value 
     * down the diagonal.
     * @param n the column and row size.
     * @param scalar the scalar value to put down the diagonal.
     * @param mc a MathContext to use in computation.
     * @return the generated scalar matrix.
     */
    public static  Matrix scalar(int n, Scalar scalar, MathContext mc) {
        Matrix C = new Matrix(n, n, mc);
        for(int i = 0; i < n; i++) {
            C.set(i, i, scalar);
        }
        return C;
    }
    
    /**
     * attempts to grab a value from a column, value index.
     * @param m the column index.
     * @param n the row index.
     * @return the value at i,j
     */
    public Scalar get(int m, int n) {
        if((m >= 0 && m < this.M) && 
                (n >= 0 && n < this.N)) {
            Vector v = this.get(m);
            return v.get(n);
        } else {
            throw new ArrayIndexOutOfBoundsException(m+":"+n+" index out of bounds.");
        }
    }
    
    /**
     * create and return the transpose of the invoking matrix.
     * @return the transpose matrix.
     */
    public Matrix transpose() {
        Matrix A = new Matrix(this.M, this.N, mc);
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                A.set(j, i, this.get(i, j));
            }
        }
        return A;
    }
    
    /**
     * Swaps rows i and j.
     * @param i the index for row i
     * @param j the index for row j
     */
    @Override
    public void swap(int i, int j) {
        Vector temp = this.get(i);
        this.set(i, this.get(j));
        this.set(j, temp);
    }
    
    /**
     * Adds an item to the end of the Vector, up to 
     * the Vectors maximum capacity.
     * @param item the item to add to the Vector.
     * @return true if the item was added, false otherwise.
     */
    @Override
    public final boolean add(Vector item) {
        if(this.size() < M) {
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
    public final void add(int index, Vector item) {
        if(this.size() >= M) {
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
    public Vector set(int index, Vector item) {
        if(index < M) {
            return super.set(index, item);
        }
        return null;
    }
    
    /**
     * Attempts to add two matrices together i.e A + B = C
     * @param B the matrix to add to this.
     * @return the computed matrix from A + B.
     */
    @Override
    public Matrix add(Type B) {
        if(B instanceof Scalar) return this.add((Scalar)B);
        Matrix b = (Matrix) B;
        Matrix A = this;
        if(b.M != A.M || b.N != A.N) throw new RuntimeException("Illegal matrix dimensions");
        Matrix C = new Matrix(M, N, mc);
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                Scalar n = A.get(i, j).add(b.get(i, j));
                C.set(i, j, n);
            }
        }
        return C;
    }
    
    /**
     * Attempts to solve a system of linear equations using 
     * the provided solver and a set of RHS values.
     * @param solver the solver to use.
     * @param b the set of RHS values.
     * @return the solved equation.
     */
    public Vector solve(LinearSystemSolver solver, Vector b) {
        return solver.get(this).solve(b);
    }
    
    /**
     * Decomposes this Matrix using the defined decomposer.
     * @param <D> The type of the returned decomposer.
     * @param decompositor the type of decomposer to use.
     * @return The decomposer after it has been run on this matrix.
     */
    public <D extends AbstractDecompositor> D decompose(LinearSystemDecompositor decompositor) {
        D d = (D) decompositor.get(this);
        d.decompose();
        return d;
    }
    
    /**
     * Attempts to calculate the inverse of this Matrix.
     * @param inverter the inverter to use.
     * @return the inverse matrix if one was able to be calculated.
     */
    public  Matrix invert(LinearSystemInverter inverter) {
        AbstractInverter i = inverter.get(this);
        return i.inverse();
    }
    
    /**
     * Attempts to minus B from this i.e A - B = C
     * @param B the matrix to subtract from this.
     * @return the computed matrix from A - B.
     */
    @Override
    public Matrix subtract(Type B) {
        if(B instanceof Scalar) return this.subtract((Scalar)B);
        Matrix A = this;
        Matrix b = (Matrix) B;
        if(b.M != A.M || b.N != A.N) throw new RuntimeException("Illegal matrix dimensions");
        Matrix C = new Matrix(M, N, mc);
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                Scalar n =  A.get(i, j).subtract(b.get(i, j));
                C.set(i, j, n);
            }
        }
        return C;
    }
    
    /**
     * Attempts matrix multiplication in the form AB = C
     * @param B the matrix to multiply with this one.
     * @return the solution to AB = C
     */
    @Override
    public Matrix multiply(Type B) {
        if(B instanceof Scalar) return this.multiply((Scalar)B);
        if(B instanceof Vector) return this.multiply((Vector)B);
        Matrix A = this;
        Matrix b = (Matrix) B;
        if(A.N != b.M) throw new RuntimeException("Illegal matrix dimensions");
        Matrix C = new Matrix(A.M, b.N, mc);
        for(int i = 0; i < C.M; i++) {
            for(int j = 0; j < C.N; j++) {
                for(int k = 0; k < A.N; k++) {
                    Scalar v = C.get(i, j);
                    Scalar a = A.get(i, k).multiply(b.get(k, j));
                    v = v.add(a);
                    C.set(i, j, v);
                }
            }
        }
        return C;
    }
    
    /**
     * Attempts to multiply a matrix by a vector.
     * The vector is converted into a single row matrix, transposed and then
     * normal multiplication takes place.
     * @param B the vector to multiply this matrix by.
     * @return the result of the computation.
     */
    private Matrix multiply(Vector B) {
        Matrix m = new Matrix(this.M, B.size(), mc);
        for(int i = 0; i < B.size(); i++) {
            m.set(0, i, B.get(i));
        }
        m = m.transpose();
        //create a new matrix from the first entry in row.
        Matrix m1 = new Matrix(B.size(), 1, mc);
        for(int i = 0; i < m.M; i++) {
            Vector c = this.get(i);
            m1.set(i, 0, c.get(0));
        }
        return this.multiply((Type)m1);
    }
    
    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Matrix)) return false;
        Matrix B = (Matrix) object;
        Matrix A = this;
        if(B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions");
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!A.get(i, j).equals(B.get(i, j))) return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.M;
        hash = 23 * hash + this.N;
        return hash;
    }
    
    /**
     * Attempts to power a matrix with an exponent.
     * @param n the exponent to power this matrix by.
     * @return the matrix powered to the exponent n.
     */
    public Matrix power(int n) {
        if(!this.is(Predicate.SQUARE)) throw new ArithmeticException("can only power square matrices");
        Matrix I = Matrix.identity(this.N, mc);
        Matrix A = this;
        
        while(n > 0) {
            if(n % 2 == 1) {
                I = (Matrix) I.multiply(A);
            }
            n /= 2;
            A = (Matrix) A.multiply(A);
        }
        
        return I;
        
    }
    
    /**
     * Adds a value at a given position in this matrix.
     * @param m the column position.
     * @param n the row position index.
     * @param value the value to set.
     */
    public void set(int m, int n, Scalar value) {
        if((m >= 0 && m < this.M) && 
                (n >= 0 && n < this.N)) {
            Vector v = this.get(m);
            v.set(n, value);
            this.set(m, v);
        } else {
            throw new ArrayIndexOutOfBoundsException(m+":"+n+" index out of bounds.");
        }
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for(int i = 0; i < this.M; i++) {
            builder.append("[");
            for(int j = 0; j < this.N; j++) {
                builder.append(this.get(i,j));
                if(j != this.N - 1) {
                    builder.append(", ");
                }
            }
            if(i != this.M - 1) {
                builder.append("]\n");
            }
        }
        builder.append("]");
        return builder.toString();
    }
    
    /**
     * Attempts to multiply a matrix by a scalar value.
     * @param scalar the scalar to multiply this matrix by
     * @return this matrix multiplied by the scalar value.
     */
    private Matrix multiply(Scalar scalar) {
        Matrix A = this;
        Matrix C = new Matrix(A.M, A.N, mc);
        for(int i = 0; i < A.M; i++) {
            for(int j = 0; i < A.N; j++) {
                Scalar d = A.get(i, j).multiply(scalar);
                C.set(i, j, new Scalar(d.doubleValue(), mc));
            }
        }
        return C;
    }

    @Override
    public Matrix divide(Type data) {
        if(data instanceof Scalar) return this.divide((Scalar)data);
        throw new ArithmeticException("matrix division is unsupported");
    }
    
    /**
     * Attempts to perform A/b = C where b is a scalar value.
     * @param scalar the scalar value to divide each element in this matrix by.
     * @return the result to A/b = C.
     */
    private Matrix divide(Scalar scalar) {
        Matrix A = this;
        Matrix C = new Matrix(A.M, A.N, mc);
        for(int i = 0; i < A.M; i++) {
            for(int j = 0; j < A.N; j++) {
                Scalar n = A.get(i, j).divide(scalar);
                C.set(i, j, n);
            }
        }
        return C;
    }
    
    /**
     * Attempts A + B = C where B is the scalar product of b.
     * @param scalar the scalar value b.
     * @return the result of A + B = C.
     */
    private Matrix add(Scalar scalar) {
        Matrix B = Matrix.scalar(this.N, scalar, mc);
        return this.add(B);
    }
    
    /**
     * Attempts A - B = C where B is the scalar product of b.
     * @param scalar the scalar value b.
     * @return the result of A - B = C.
     */
    private Matrix subtract(Scalar scalar) {
        Matrix B = Matrix.scalar(this.N, scalar, mc);
        return this.subtract(B);
    }

    @Override
    public Scalar min() {
        Scalar min = null;
        for(int i = 0; i < this.M; i++) {
            Scalar colMin = Collections.min(this.get(i));
            if(min == null && i == 0) {
                min = colMin;
                continue;
            }
            if(colMin.compareTo(min) == -1) {
                min = colMin;
            }
        }
        return min;
    }

    @Override
    public Scalar max() {
        Scalar max = null;
        for(int i = 0; i < this.M; i++) {
            Scalar colMax = Collections.max(this.get(i));
            if(max == null && i == 0) {
                max = colMax;
                continue;
            }
            if(colMax.compareTo(max) == 1) {
                max = colMax;
            }
        }
        return max;
    }

    @Override
    public boolean sizeOf(Object object) {
        if(!(object instanceof Matrix)) return false;
        Matrix m = (Matrix) object;
        return (this.M == m.M && this.N == m.N);
    }

    @Override
    public int compareTo(Arithmetic O) {
        
        if(!(O instanceof Matrix)) throw new ArithmeticException("must compare a matrix to a matrix");
        
        Matrix o = (Matrix) O;
        
        if(!this.sizeOf(o)) throw new ArithmeticException("Matrices need to be the same length");
        
        if(this.equals(o)) return 0;
        
        HashMap<Integer, Integer> in = new HashMap<>();
        List<Vector> t = this;
        List<Vector> ot = o;
        for(int j = 0; j < t.size(); j++) {
            Vector et = t.get(j);
            Vector oe = ot.get(j);
            //run compareTo on the values in the vector.
            for(int i = 0; i < et.size(); i++) {
                int e = et.get(i).compareTo(oe.get(i));
                if(e != 0) {
                    if(!in.containsKey(e)) {
                        in.put(e, 0);
                    }
                    int ei = in.get(e);
                    ei++;
                    in.put(e, ei);
                }
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
    public Matrix remainder(Type data) {
        if(data instanceof Scalar) return this.mod((Scalar)data);
        Matrix A = this;
        Matrix B = (Matrix) data;
        if((A.M != B.M) || A.N != B.N) throw new ArithmeticException("invalid matrix dimensions");
        
        Matrix C = Matrix.from(A, mc);
        for(int i = 0; i < A.M; i++) {
            for(int j = 0; j < A.N; j++) {
               Scalar n = A.get(i,j).remainder(B.get(i,j));
               C.set(i, j, n);
            }
        }
        return C;
    }
    
    /**
     * Attempts A%b = C where b is a scalar value.
     * @param scalar the scalar value.
     * @return the result of A%b = C
     */
    private Matrix mod(Scalar scalar) {
        Matrix A = this;
        
        Matrix C = Matrix.from(A, mc);
        for(int i = 0; i < A.M; i++) {
            for(int j = 0; j < A.N; j++) {
               Scalar n = A.get(i,j).remainder(scalar);
               C.set(i, j, n);
            }
        }
        return C;
    }
    
    @Override
    public Scalar sum() {
        Scalar t = Scalar.ZERO;
        for(int i = 0; i < this.M; i++) {
            t = (Scalar) t.add(this.get(i).sum());
        }
        return t;
    }

    @Override
    public Matrix apply(Handler handler) {
        Matrix A = this;
        Matrix B = Matrix.from(A, mc);
        for(int i = 0; i < A.M; i++) {
            for(int j = 0; j < A.N; j++) {
                Scalar s = handler.handle(A.get(i, j), mc);
                B.set(i, j, s);
            }
        }
        return B;
    }

    @Override
    public Matrix slice(Coordinate start, Coordinate end) {
        if(end.x - start.x < 0 || end.y - start.y < 0) {
            throw new ArithmeticException("invalid dimensions");
        }
        
        if(start.equals(Coordinate.COORDINATE_START)) {
            start.x = 0; start.y = 0;
        }
        
        if(end.equals(Coordinate.COORDINATE_END)) {
            end.x = this.M; end.y = this.N;
        }
        
        Matrix m = Matrix.zeroes(end.x - start.x, end.y - start.y, mc);
        for(int i = start.x; i < end.x; i++) {
            for(int j = start.y; j < end.y; j++) {
                m.set(i - start.x, j - start.y, this.get(i, j));
            }
        }
        return m;
    }

    @Override
    public Matrix addColumn(int index, Type value) {
        if(!(value instanceof Vector)) throw new IllegalArgumentException("columns in a matrix can only be a vector.");
        if(index < 0 || index > N) throw new ArrayIndexOutOfBoundsException("invalid index defined.");
        Matrix m = Matrix.zeroes(M, N + 1);
        Vector v = (Vector) value;
        if(v.size() != M) throw new ArithmeticException("vectors dimensions do not match that of the matrix");
        for(int i = 0; i < this.M; i++) {
            for(int j = 0; j < index; j++) {
                m.set(i, j, this.get(i, j));
            }
        }
        for(int i = 0; i < v.size(); i++) {
            m.set(i, index, v.get(i));
        }
        for(int i = 0; i < this.M; i++) {
            for(int j = index + 1; j < m.N; j++) {
                m.set(i, j, this.get(i, j - 1));
            }
        }
        return m;
    }

    @Override
    public Matrix addRow(int index, Type type) {
        if(!(type instanceof Vector)) throw new IllegalArgumentException("columns in a matrix can only be a vector.");
        if(index < 0 || index > M) throw new ArrayIndexOutOfBoundsException("invalid index defined.");
        Vector v = (Vector) type;
        if(v.size() != N) throw new ArithmeticException("vectors dimensions do not match that of the matrix.");
        Matrix m = Matrix.zeroes(M + 1, N, mc);
        for(int i = 0; i < index; i++) {
            for(int j = 0; j < this.N; j++) {
                m.set(i, j, this.get(i, j));
            }
        }
        for(int i = 0; i < this.N; i++) {
            m.set(index, i, v.get(i));
        }
        for(int i = index + 1; i < m.M; i++) {
            for(int j = 0; j < this.N; j++) {
                m.set(i, j, this.get(i - 1, j));
            }
        }
        return m;
    }

    @Override
    public int getRowSize() {
        return M;
    }

    @Override
    public int getColumnSize() {
        return N;
    }
    
    /**
     * Attempts to apply a handler to all of the elements in row {@code m}.
     * @param m the row to apply the handler to.
     * @param handler the handler to apply.
     * @return the newly created data structure.
     */
    public Matrix applyToRow(int m, Handler handler) {
        if(m < 0 || m >= M) {
            throw new ArithmeticException("invalid row index.");
        }
        Matrix A = this;
        Matrix B = Matrix.from(A, mc);
        for(int i = 0; i < M; i++) {
           Vector v = this.get(i);
           if(i == m) {
               v = v.apply(handler);
           }
           B.set(i, v);
        }
        return B;
    }
    
    /**
     * Attempts to apply a handler to all of the elements in row {@code m}.
     * @param m the row to apply the handler to.
     * @param handler the handler to apply.
     * @return the newly created data structure.
     */
    public Matrix applyToRow(int m, Functions handler) {
        return this.applyToRow(m, handler.get());
    }
    
    /**
     * Attempts to apply a handler to all of the elements in column {@code n}.
     * @param n the column to apply the handler to.
     * @param handler the handler to apply.
     * @return the newly created data structure.
     */
    public Matrix applyToColumn(int n, Handler handler) {
        if(n < 0 || n >= N) {
            throw new ArithmeticException("invalid column index.");
        }
        Matrix A = this;
        Matrix B = Matrix.from(A, mc);
        for(int i = 0; i < M; i++) {
            Vector v = A.get(i);
            v.set(n, handler.handle(v.get(n), mc));
            B.set(i, v);
        }
        return B;
    }
    
    /**
     * Attempts to apply a handler to all of the elements in column {@code n}.
     * @param n the column to apply the handler to.
     * @param handler the handler to apply.
     * @return the newly created data structure.
     */
    public Matrix applyToColumn(int n, Functions handler) {
        return this.applyToColumn(n, handler.get());
    }
    
    @Override
    public Matrix copy() {
        Matrix m = Matrix.from(this, mc);
        for(int i = 0; i < this.M; i++) {
            Vector v = this.get(i).copy();
            m.set(i, v);
        }
        return m;
    }
    
    /**
     * Tests to see if this Matrix is a certain predicate.
     * @param predicate the predicate to test.
     * @return true if this matrix is the predicate, false otherwise.
     */
    public boolean is(Predicate predicate) {
        return predicate.test(this);
    }
    
    /**
     * Calculates the rank of a matrix.
     * The rank of a matrix is the number of linearly independent rows of a full matrix.
     * @return the rank of a matrix.
     */
    public Scalar rank() {
        if(this.getRowSize() == 0 || this.getColumnSize() == 0) {
            return Scalar.ZERO;
        }
        SingleValueDecomposition svd = this.decompose(LinearSystemDecompositor.SINGLE_VALUE);
        Matrix s = svd.getD();
        Scalar tol = new Scalar(
            Math.max(M, N) * s.get(0, 0).doubleValue() * AbstractSolver.EPSILON
        );
        Scalar rank = Scalar.ZERO;
        for(int i = 0; i < s.getRowSize(); i++) {
            if(s.get(i, i).compareTo(tol) == 1) {
                rank = (Scalar) rank.add(Scalar.ONE);
            }
        }
        return rank;
    }
    
    /**
     * Calculates the determinant of a matrix.
     * The determinant is used to determine if a solution exists to a system of
     * linear equations. If the determinant is zero, then the system is singular and
     * this system doesn't have an inverse.
     * @return the determinant.
     */
    public Scalar determinant() {
        if(!this.is(Predicate.SQUARE)) {
            throw new ArithmeticException("can only calculate the determinant from a square matrix.");
        }
        
        switch (M) {
            case 0:
                return Scalar.ZERO;
            case 1:
                return get(0, 0);
            case 2:
                return (Scalar) (get(0, 0).multiply(get(1, 1))).subtract((get(0, 1).multiply(get(1, 0))));
            case 3:
                Scalar one = (Scalar) get(0, 0).multiply(get(1, 1)).multiply(get(2, 2));
                Scalar two = (Scalar) get(0, 1).multiply(get(1, 2)).multiply(get(2, 0));
                Scalar three = (Scalar) get(0, 2).multiply(get(1, 0)).multiply(get(2, 1));
                Scalar four = (Scalar) get(0, 2).multiply(get(1, 1)).multiply(get(2, 0));
                Scalar five = (Scalar) get(0, 1).multiply(get(1, 0)).multiply(get(2, 2));
                Scalar six = (Scalar) get(0, 0).multiply(get(1, 2)).multiply(get(2, 1));
                return (Scalar) one.add(two).add(three).subtract(four).subtract(five).subtract(six);
        }
        
        LUDecompositor lu = this.decompose(LinearSystemDecompositor.LU);
        Matrix P = lu.getP();
        Scalar res = this.diagonalProduct();
        int[] p = new int[P.M];
        for(int i = 0; i < P.M; i++) {
            for(int j = 0; j < P.N; j++) {
                if(P.get(i, j).compareTo(Scalar.ZERO) == 1) {
                    p[i] = j;
                    break;
                }
            }
        }
        
        int sign = 1;
        for(int i = 0; i < p.length; i++) {
            for(int j = i + 1; j < p.length; j++) {
                if(p[j] < p[i]) {
                    sign *= -1;
                }
            }
        }
        
        return new Scalar(sign * res.doubleValue());
        
    }
    
    /**
     * Determines the diagonal product of this matrix.
     * @return the diagonal product.
     */
    public Scalar diagonalProduct() {
        Scalar r = Scalar.ONE;
        for(int i = 0; i < this.M; i++) {
            r = (Scalar) r.multiply(this.get(i, i));
        }
        return r;
    }
    
    /**
     * Replaces the column at index {@code n} with {@code col}
     * @param n the index to replace.
     * @param col the column to replace with.
     * @return the new matrix after the replacement.
     */
    public Matrix setColumn(int n, Vector col) {
        if(n > N - 1) throw new ArithmeticException("invalid index");
        if(col.size() != N) throw new ArithmeticException("column vector is the wrong size.");
        Matrix m = this.copy();
        for(int i = 0; i < M; i++) {
            Vector c = m.get(i);
            c.set(n, col.get(i));
            m.set(i, c);
        }
        return m;
    }
    
    /**
     * Replaces the row at index {@code m} with {@code row}
     * @param m the index to replace.
     * @param row the row to replace with.
     * @return the new matrix after the replacement.
     */
    public Matrix setRow(int m, Vector row) {
        if(m > M - 1) throw new ArithmeticException("invalid index");
        if(row.size() != M) throw new ArithmeticException("column vector is the wrong size.");
        Matrix ma = this.copy();
        ma.set(m, row);
        return ma;
    }
    
}
