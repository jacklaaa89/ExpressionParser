package org.expression;

import org.expression.computation.Handler;
import org.expression.computation.Arithmetic;
import org.expression.computation.Functions;
import java.math.MathContext;

/**
 *
 * @author jacktimblin
 */
public class Scalar implements Arithmetic<Arithmetic>  {
    
    public static final Scalar ZERO = new Scalar(0d);
    public static final Scalar ONE  = new Scalar(1d);
    public static final Scalar TWO  = new Scalar(2d); 
    
    private final MathContext mc;
    public final double value;
    
    public Scalar(double val) {
        this.value = val;
        this.mc = MathContext.DECIMAL32;
    }
    
    public Scalar(String value) {
        this(Double.parseDouble(value));
    }
    
    public Scalar(double val, MathContext mc) {
        this.value = val;
        this.mc = mc;
    }
    
    public static Scalar random() {
        return Scalar.random(MathContext.DECIMAL32);
    }
    
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
    
    public double doubleValue() {
        return this.value;
    }
    
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

    public int intValue() {
        return (int) Math.round(value);
    }
    
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
    
    public Scalar power(Scalar n) {
        return new Scalar(Math.pow(value, n.value));
    }
    
    @Override
    public String toString() {
        return  ""+this.value;
    }
    
}
