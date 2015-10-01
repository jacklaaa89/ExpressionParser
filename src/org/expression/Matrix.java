package org.expression;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * A representation of a Matrix.
 * @author Jack Timblin
 */
public class Matrix implements Arithmetic {
    
    /**
     * The internal data structure for the matrix.
     */
    private final Scalar[][] _matrix;
    
    /**
     * the column size of this matrix
     */
    private final int M;
    
    /**
     * the row size in this matrix
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
        this._matrix = new Scalar[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                this._matrix[i][j] = new Scalar(0d);
            }
        }
        this.M = m;
        this.N = n;
        this.mc = mc;
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
        int i = 0; boolean first = true;
        if(columns.isEmpty()) {
            throw new ArithmeticException("need at least one column");
        }
        
        int size = columns.get(0).size();
        this.M = columns.size();
        this.N = size;
        this._matrix = new Scalar[M][N];
        for(int j = 0; j < columns.size(); j++) {
            Vector e = columns.get(j);
            if(!first) {
                if(e.size() != i) throw new ArithmeticException("invalid column length");
            }
            i = e.size();
            first = false;
            for(int k = 0; k < e.size(); k++) {
                this._matrix[j][k] = e.get(k);
            }
        }
        this.mc = mc;
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
        M = data.length;
        N = data[0].length;
        this._matrix = new Scalar[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                this._matrix[i][j] = data[i][j];
            }
        }
        this.mc = mc;
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
     * Initializes a new Matrix from another Matrix (i.e clone)
     * @param A the Matrix to clone from.
     * @param mc the MathContext to use in computation.
     */
    private Matrix(Matrix A, MathContext mc) { this(A._matrix, mc); }
    
    /**
     * Initializes a new Matrix from another Matrix (i.e clone),
     * using a DECIMAL32 MathContext.
     * @param A the Matrix to clone from.
     */
    private Matrix(Matrix A) { this(A, MathContext.DECIMAL32); }
    
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
               C.add(i, j, new Scalar(Math.random()));
            }
        }
        return C;
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
            C.add(i, i, new Scalar(1d));
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
            C.add(i, i, scalar);
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
            return this._matrix[m][n];
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
                A.add(j, i, this.get(i, j));
            }
        }
        return A;
    }
    
    /**
     * Swaps rows i and j.
     * @param i the index for row i
     * @param j the index for row j
     */
    public void swap(int i, int j) {
        Scalar[] temp = this.getColumn(i);
        this._matrix[i] = this.getColumn(j);
        this._matrix[j] = temp;
    }
    
    /**
     * Attempts to add two matrices together i.e A + B = C
     * @param B the matrix to add to this.
     * @return the computed matrix from A + B.
     */
    @Override
    public Type plus(Type B) {
        if(B instanceof Scalar) return this.plus((Scalar)B);
        Matrix b = (Matrix) B;
        Matrix A = this;
        if(b.M != A.M || b.N != A.N) throw new RuntimeException("Illegal matrix dimensions");
        Matrix C = new Matrix(M, N, mc);
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                BigDecimal value = A.get(i, j).add(b.get(i, j), mc);
                Scalar n = new Scalar(value.doubleValue(), mc);
                C.add(i, j, n);
            }
        }
        return C;
    }
    
    /**
     * Attempts to minus B from this i.e A - B = C
     * @param B the matrix to subtract from this.
     * @return the computed matrix from A - B.
     */
    @Override
    public Type minus(Type B) {
        if(B instanceof Scalar) return this.minus((Scalar)B);
        Matrix A = this;
        Matrix b = (Matrix) B;
        if(b.M != A.M || b.N != A.N) throw new RuntimeException("Illegal matrix dimensions");
        Matrix C = new Matrix(M, N, mc);
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                BigDecimal value = A.get(i, j).subtract(b.get(i, j), mc);
                Scalar n = new Scalar(value.doubleValue(), mc);
                C.add(i, j, n);
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
    public Type multiply(Type B) {
        if(B instanceof Scalar) return this.multiply((Scalar)B);
        if(B instanceof Vector) return this.multiply((Vector)B);
        Matrix A = this;
        Matrix b = (Matrix) B;
        if(A.N != b.M) throw new RuntimeException("Illegal matrix dimensions");
        Matrix C = new Matrix(A.M, b.N, mc);
        for(int i = 0; i < C.M; i++) {
            for(int j = 0; j < C.N; j++) {
                for(int k = 0; k < A.N; k++) {
                    BigDecimal v = C.get(i, j);
                    BigDecimal a = A.get(i, k).multiply(b.get(k, j), mc);
                    v = v.add(a, mc);
                    Scalar n = new Scalar(v.doubleValue(), mc);
                    C.add(i, j, n);
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
    public Type multiply(Vector B) {
        Matrix m = new Matrix(this.M, B.size(), mc);
        for(int i = 0; i < B.size(); i++) {
            m.add(0, i, B.get(i));
        }
        m = m.transpose();
        //create a new matrix from the first entry in row.
        Matrix m1 = new Matrix(B.size(), 1, mc);
        for(int i = 0; i < m.M; i++) {
            Scalar[] c = this.getColumn(i);
            m1.add(i, 0, c[0]);
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
     * determines if this Matrix is square.
     * @return <b>TRUE</b> if this matrix is square, <b>FALSE</b> otherwise.
     */
    public boolean isSquare() {
        return this.M == this.N;
    }
    
    /**
     * Attempts to power a matrix with an exponent.
     * @param n the exponent to power this matrix by.
     * @return the matrix powered to the exponent n.
     */
    public Matrix power(int n) {
        if(!this.isSquare()) throw new ArithmeticException("can only power square matrices");
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
     * gets the column size of this matrix (M)
     * @return the column size.
     */
    public int getM() {
        return M;
    }
    
    /**
     * gets the row size of this matrix (N)
     * @return the row size
     */
    public int getN() {
        return N;
    }
    
    /**
     * retrieve a column of this matrix at a given column index.
     * @param m the column index to retrieve.
     * @return the column vector at column m in this matrix.
     */
    public Scalar[] getColumn(int m) {
        if((m >= 0 && m < this.M)) {
            return this._matrix[m];
        } else {
            throw new ArrayIndexOutOfBoundsException(m + "column index out of bounds.");
        }
    }
    
    /**
     * Adds a value at a given position in this matrix.
     * @param m the column position.
     * @param n the row position index.
     * @param value the value to set.
     */
    public void add(int m, int n, Scalar value) {
        if((m >= 0 && m < this.M) && 
                (n >= 0 && n < this.N)) {
            this._matrix[m][n] = value;
        } else {
            throw new ArrayIndexOutOfBoundsException(m+":"+n+" index out of bounds.");
        }
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i = 0; i < this.M; i++) {
            for(int j = 0; j < this.N; j++) {
                builder.append(this.get(i,j));
                if(j != this.N - 1) {
                    builder.append(", ");
                }
            }
            if(i != this.M - 1) {
                builder.append("; ");
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
    public Matrix multiply(Scalar scalar) {
        Matrix A = this;
        Matrix C = new Matrix(A.M, A.N, mc);
        for(int i = 0; i < A.M; i++) {
            for(int j = 0; i < A.N; j++) {
                BigDecimal d = A.get(i, j).multiply(scalar, mc);
                C.add(i, j, new Scalar(d.doubleValue(), mc));
            }
        }
        return C;
    }

    @Override
    public Type divide(Type data) {
        if(data instanceof Scalar) return this.divide((Scalar)data);
        throw new ArithmeticException("matrix division is unsupported");
    }
    
    /**
     * Attempts to perform A/b = C where b is a scalar value.
     * @param scalar the scalar value to divide each element in this matrix by.
     * @return the result to A/b = C.
     */
    public Matrix divide(Scalar scalar) {
        Matrix A = this;
        Matrix C = new Matrix(A.M, A.N, mc);
        for(int i = 0; i < A.M; i++) {
            for(int j = 0; j < A.N; j++) {
                BigDecimal d = A.get(i, j).divide(scalar, mc);
                Scalar n = new Scalar(d.doubleValue(), mc);
                C.add(i, j, n);
            }
        }
        return C;
    }
    
    /**
     * Attempts A + B = C where B is the scalar product of b.
     * @param scalar the scalar value b.
     * @return the result of A + B = C.
     */
    public Type plus(Scalar scalar) {
        Matrix B = Matrix.scalar(this.N, scalar, mc);
        return this.plus(B);
    }
    
    /**
     * Attempts A - B = C where B is the scalar product of b.
     * @param scalar the scalar value b.
     * @return the result of A - B = C.
     */
    public Type minus(Scalar scalar) {
        Matrix B = Matrix.scalar(this.N, scalar, mc);
        return this.minus(B);
    }

    @Override
    public Scalar min() {
        Scalar min = null;
        for(int i = 0; i < this.M; i++) {
            Scalar colMin = Collections.min(Arrays.asList(this.getColumn(i)));
            if(min == null && i == 0) {
                min = colMin;
                continue;
            }
            if(colMin.compareTo((Type)min) == -1) {
                min = colMin;
            }
        }
        return min;
    }
    
    /**
     * Converts this Matrix into a list of Vectors.
     * @return this matrix as a list of Vectors.
     */
    public List<Vector> toList() {
        List<Vector> e = new ArrayList<>();
        for(int i = 0; i < this.M; i++) {
            Vector v = new Vector(this.N);
            for(int j = 0; j < this.N; j++) {
                v.set(j, this.get(i, j));
            }
            e.add(v);
        }
        return e;
    }

    @Override
    public Scalar max() {
        Scalar max = null;
        for(int i = 0; i < this.M; i++) {
            Scalar colMax = Collections.max(Arrays.asList(this.getColumn(i)));
            if(max == null && i == 0) {
                max = colMax;
                continue;
            }
            if(colMax.compareTo((Type)max) == 1) {
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
    public int compareTo(Type O) {
        
        if(!(O instanceof Matrix)) throw new ArithmeticException("must compare a matrix to a matrix");
        
        Matrix o = (Matrix) O;
        
        if(!this.sizeOf(o)) throw new ArithmeticException("Matrices need to be the same length");
        
        if(this.equals(o)) return 0;
        
        HashMap<Integer, Integer> in = new HashMap<>();
        List<Vector> t = this.toList();
        List<Vector> ot = o.toList();
        for(int j = 0; j < t.size(); j++) {
            Vector et = t.get(j);
            Vector oe = ot.get(j);
            //run compareTo on the values in the vector.
            for(int i = 0; i < et.size(); i++) {
                int e = et.get(i).compareTo((Type)oe.get(i));
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
    public Type remainder(Type data) {
        if(data instanceof Scalar) return this.remainder((Scalar)data);
        Matrix A = this;
        Matrix B = (Matrix) data;
        if((A.M != B.M) || A.N != B.N) throw new ArithmeticException("invalid matrix dimensions");
        
        Matrix C = Matrix.from(A, mc);
        for(int i = 0; i < A.M; i++) {
            for(int j = 0; j < A.N; j++) {
               BigDecimal d = A.get(i,j).remainder(B.get(i,j), mc);
               C.add(i,j, new Scalar(d.doubleValue(), mc));
            }
        }
        return C;
    }
    
    /**
     * Attempts A%b = C where b is a scalar value.
     * @param scalar the scalar value.
     * @return the result of A%b = C
     */
    public Matrix remainder(Scalar scalar) {
        Matrix A = this;
        
        Matrix C = Matrix.from(A, mc);
        for(int i = 0; i < A.M; i++) {
            for(int j = 0; j < A.N; j++) {
               BigDecimal d = A.get(i,j).remainder(scalar, mc);
               C.add(i,j, new Scalar(d.doubleValue(), mc));
            }
        }
        return C;
    }
    
    @Override
    public Scalar sum() {
        Scalar t = Scalar.ZERO;
        for(int i = 0; i < this.M; i++) {
            for(int j = 0; j < this.N; j++) {
                BigDecimal d = t.add(this.get(i, j), mc);
                t = new Scalar(d.doubleValue(), mc);
            }
        }
        return t;
    }

    @Override
    public Matrix apply(Handler handler) {
        Matrix A = this;
        Matrix B = Matrix.from(A, mc);
        for(int i = 0; i < A.M; i++) {
            for(int j = 0; j < A.N; j++) {
                Scalar s = handler.handle(A.get(i, j));
                B.add(i, j, s);
            }
        }
        return B;
    }
    
}
