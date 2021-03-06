package org.expression;

import org.expression.computation.Handler;
import org.expression.computation.Arithmetic;
import org.expression.computation.Functions;
import org.expression.exception.DivisonByZeroException;

/**
 * A representation of a Scalar value. It is effectively a container for
 * a Double values which provide OOP design patterns for performing arithmetic
 * functions.
 * @author Jack Timblin
 */
public class Scalar implements Arithmetic<Arithmetic>  {
    
    /**
     * Generates a new Scalar with a zero value.
     */
    public static final Scalar ZERO = new Scalar(0d);
    
    /**
     * Generates a new Scalar with a value of one.
     */
    public static final Scalar ONE  = new Scalar(1d);
    
    /**
     * Generates a new Scalar with a value of two.
     */
    public static final Scalar TWO  = new Scalar(2d); 
    
    /**
     * The value of this Scalar.
     */
    public final double value;
    
    /**
     * Initializes a Scalar value
     * @param val the initial value of this scalar.
     */
    public Scalar(double val) {
        this.value = val;
    }
    
    /**
     * Initializes a Scalar value
     * @param value the initial value of this scalar to be parsed into a double.
     */
    public Scalar(String value) {
        this(Double.parseDouble(value));
    }
    
    /**
     * Generates a Scalar with a random value between 0 and 1
     * @return the random Scalar value.
     */
    public static Scalar random() {
        return new Scalar(Math.random());
    }
    
    /**
     * Returns the larger of the two Scalar values.
     * @param o1 an argument
     * @param o2 another argument.
     * @return the larger of {@code o1} and {@code o2}.
     */
    public static Scalar max(Scalar o1, Scalar o2) {
        return new Scalar(Math.max(o1.value, o2.value));
    }
    
    /**
     * Returns the smaller of the two Scalar values.
     * @param o1 an argument
     * @param o2 another argument.
     * @return the smaller of {@code o1} and {@code o2}.
     */
    public static Scalar min(Scalar o1, Scalar o2) {
        return new Scalar(Math.min(o1.value, o2.value));
    }
    
    /**
     * Returns the square root of a particular value.
     * @param v the value to sqrt.
     * @return the value square rooted.
     */
    public static Scalar sqrt(Scalar v) {
        return new Scalar(Math.sqrt(v.value));
    }
    
    /**
     * Returns sqrt(x2 + y2).
     * @param a the x value.
     * @param b the y value.
     * @return sqrt(x2 + y2)
     */
    public static Scalar hypot(Scalar a, Scalar b) {
        Scalar result;
        if(a.abs().compareTo(b.abs()) == 1) {
            Scalar e = b.divide(a);
            double ed = e.doubleValue();
            Scalar f = new Scalar(Math.sqrt(1 + ed * ed));
            result = a.abs().multiply(f);
        } else if(!b.equals(Scalar.ZERO)) {
            Scalar e = a.divide(b);
            double ed = e.doubleValue();
            Scalar f = new Scalar(Math.sqrt(1 + ed * ed));
            result = b.abs().multiply(f);
        } else {
            result = Scalar.ZERO;
        }
        return result;
    }
    
    @Override
    public Scalar apply(Handler handler) {
        return (Scalar) handler.handle(this);
    }

    @Override
    public Arithmetic multiply(Type data) {
        if(data instanceof Scalar) return this.multiply((Scalar)data);
        Handler h = (Handler) (Scalar o1) -> {
            return (Scalar) this.multiply(o1);
        };
        return (Arithmetic) data.apply(h);
    }
    
    /**
     * Perform A*C to give C.
     * @param value the data.
     * @return the computed data structure.
     */
    public Scalar multiply(Scalar value) {
        return new Scalar(((Scalar)value).value*this.value);
    }

    @Override
    public Arithmetic divide(Type data) {
        if(data instanceof Scalar) return this.divide((Scalar)data);
        Handler h = (Handler) (Scalar o1) -> {
            return (Scalar) this.divide(o1);
        };
        return (Arithmetic) data.apply(h);
    }
    
    /**
     * Perform A/C to give C.
     * @param data the data.
     * @return the computed data structure.
     */
    public Scalar divide(Scalar data) {
        if(data.equals(ZERO)) {throw new DivisonByZeroException("Division by Zero.", this, data); }
        return new Scalar(this.value/((Scalar)data).value);
    }

    @Override
    public Arithmetic add(Type data) {
        if(data instanceof Scalar) return this.add((Scalar)data);
        Handler h = (Handler) (Scalar o1) -> {
            return (Scalar) this.add(o1);
        };
        return (Arithmetic) data.apply(h);
    }
    
    /**
     * Perform A+C to give C.
     * @param data the data.
     * @return the computed data structure.
     */
    public Scalar add(Scalar data) {
        return new Scalar(this.value+((Scalar)data).value);
    }

    @Override
    public Arithmetic subtract(Type data) {
        if(data instanceof Scalar) return this.subtract((Scalar)data);
        Handler h = (Handler) (Scalar o1) -> {
            return (Scalar) this.subtract(o1);
        };
        return (Arithmetic) data.apply(h);
    }
    
    /**
     * Perform A-B to give C.
     * @param value the data.
     * @return the computed data structure.
     */
    public Scalar subtract(Scalar value) {
        return new Scalar(this.value-((Scalar)value).value);
    }

    @Override
    public Arithmetic remainder(Type data) {
        if(data instanceof Scalar) return this.remainder((Scalar)data);
        Handler h = (Handler) (Scalar o1) -> {
            return (Scalar) this.remainder(o1);
        };
        return (Arithmetic) data.apply(h);
    }
    
    /**
     * Perform A%B to give C.
     * @param data the data.
     * @return the computed data structure.
     */
    public Scalar remainder(Scalar data) {
        double d = ((Scalar) data).value;
        return new Scalar(this.value % d);
    }

    @Override
    public Scalar min() {
        return this;
    }

    @Override
    public Scalar max() {
        return this;
    }

    @Override
    public Scalar sum() {
        return this;
    }
    
    /**
     * Returns this {@code Scalar} as a double.
     * This function works as a placeholder for {@code this.value}.
     * @return this scalar represented as a double.
     */
    public double doubleValue() {
        return this.value;
    }
    
    /**
     * returns the square root of this value.
     * @return  the sqrt of this value.
     */
    public Scalar sqrt() {
        return new Scalar(Math.sqrt(value));
    }

    @Override
    public boolean sizeOf(Object object) {
        if(!(object instanceof Scalar)) return false;
        Scalar o = (Scalar) object;
        return this.equals(o);
    }
    
    @Override
    public Scalar apply(Functions handle) {
        return this.apply(handle.get());
    }

    @Override
    public Scalar bitwiseLeft(Scalar value) {
        double v = this.value;
        for(int i = 0; i < value.value; i++) {
            v *= 10;
        }
        return new Scalar(v);
    }

    @Override
    public Scalar bitwiseRight(Scalar value) {
        double v = this.value;
        for(int i = 0; i < value.value; i++) {
            v /= 10;
        }
        return new Scalar(v);
    }

    @Override
    public Scalar negate() {
        return new Scalar(-value);
    }

    @Override
    public Scalar plus() {
        return new Scalar(+value);
    }

    @Override
    public Scalar abs() {
        return new Scalar(Math.abs(value));
    }

    @Override
    public int compareTo(Arithmetic o) {
        if(!(o instanceof Scalar)) return -1;
        Double d = this.value;
        return d.compareTo(((Scalar)o).value);
    }
    
    /**
     * return the value of this {@code Scalar} represented as an integer.
     * @return this scalar as an integer
     */
    public int intValue() {
        return (int) Math.round(value);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Scalar)) return false;
        return this.compareTo((Scalar)o) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        return hash;
    }
    
    /**
     * Increments the value of this Scalar by one.
     * @return this value incremented by one.
     */
    @Override
    public Scalar increment() {
        return this.add(Scalar.ONE);
    }
    
    /**
     * Decrements the value of this Scalar by one.
     * @return this value decremented by one.
     */
    @Override
    public Scalar decrement() {
        return this.subtract(Scalar.ONE);
    }
    
    /**
     * returns this raised to the power of {@code n}.
     * @param n the exponent
     * @return the value of {@code this}<sup>{@code n}</sup>.
     */
    public Scalar power(Scalar n) {
        return new Scalar(Math.pow(value, n.value));
    }
    
    @Override
    public String toString() {
        return  ""+this.value;
    }
    
}
