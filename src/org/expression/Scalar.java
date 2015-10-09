package org.expression;

import org.expression.computation.Handler;
import org.expression.computation.Arithmetic;
import org.expression.computation.Functions;
import java.math.MathContext;

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
     * The MathContext to use.
     */
    private final MathContext mc;
    
    /**
     * The value of this Scalar.
     */
    public final double value;
    
    /**
     * Initializes a Scalar value using a given MathContext,
     * using a DECIMAL32 MathContext.
     * @param val the initial value of this scalar.
     */
    public Scalar(double val) {
        this.value = val;
        this.mc = MathContext.DECIMAL32;
    }
    
    /**
     * Initializes a Scalar value using a given MathContext.
     * @param value the initial value of this scalar to be parsed into a double.
     */
    public Scalar(String value) {
        this(Double.parseDouble(value));
    }
    
    /**
     * Initializes a Scalar value using a given MathContext.
     * @param val the initial value of this scalar.
     * @param mc A MathContext to use.
     */
    public Scalar(double val, MathContext mc) {
        this.value = val;
        this.mc = mc;
    }
    
    /**
     * Generates a Scalar with a random value between 0 and 1, 
     * using a DECIMAL32 MathContext.
     * @return the random Scalar value.
     */
    public static Scalar random() {
        return Scalar.random(MathContext.DECIMAL32);
    }
    
    /**
     * Generates a Scalar with a random value between 0 and 1.
     * @param mc A MathContext to use.
     * @return the random Scalar value.
     */
    public static Scalar random(MathContext mc) {
        return new Scalar(Math.random(), mc);
    }
    
    @Override
    public Scalar apply(Handler handler) {
        return (Scalar) handler.handle(this, mc);
    }

    @Override
    public Arithmetic multiply(Type data) {
        if(data instanceof Scalar) return this.multiply((Scalar)data);
        Handler h = (Handler) (Scalar o1, MathContext mcon) -> {
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
        return new Scalar(((Scalar)value).value*this.value, mc);
    }

    @Override
    public Arithmetic divide(Type data) {
        if(data instanceof Scalar) return this.divide((Scalar)data);
        Handler h = (Handler) (Scalar o1, MathContext mcon) -> {
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
        return new Scalar(this.value/((Scalar)data).value, mc);
    }

    @Override
    public Arithmetic add(Type data) {
        if(data instanceof Scalar) return this.add((Scalar)data);
        Handler h = (Handler) (Scalar o1, MathContext mcon) -> {
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
        return new Scalar(this.value+((Scalar)data).value, mc);
    }

    @Override
    public Arithmetic subtract(Type data) {
        if(data instanceof Scalar) return this.subtract((Scalar)data);
        Handler h = (Handler) (Scalar o1, MathContext mcon) -> {
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
        return new Scalar(this.value-((Scalar)value).value, mc);
    }

    @Override
    public Arithmetic remainder(Type data) {
        if(data instanceof Scalar) return this.remainder((Scalar)data);
        Handler h = (Handler) (Scalar o1, MathContext mcon) -> {
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
        return new Scalar(-value, mc);
    }

    @Override
    public Scalar plus() {
        return new Scalar(+value, mc);
    }

    @Override
    public Scalar abs() {
        return new Scalar(Math.abs(value), mc);
    }

    @Override
    public int compareTo(Arithmetic o) {
        if(!(o instanceof Scalar)) return -1;
        Double d = ((Scalar)o).value;
        return d.compareTo(this.value);
    }
    
    /**
     * return the value of this {@code Scalar} represented as an int.
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
