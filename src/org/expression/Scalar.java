package org.expression;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 *
 * @author jacktimblin
 */
public class Scalar extends BigDecimal implements Type<Scalar>, Arithmetic<Scalar>  {
    
    public static final Scalar ZERO = new Scalar(0d);
    public static final Scalar ONE  = new Scalar(1d);
    
    public Scalar(double val) {
        super(val);
    }
    
    public Scalar(BigInteger i, int precision) {
        super(i, precision);
    }
    
    public Scalar(double val, MathContext mc) {
        super(val, mc);
    }
    
    public static Scalar random() {
        return new Scalar(Math.random());
    }
    
    @Override
    public Scalar apply(Handler handler) {
        return (Scalar) handler.handle(this);
    }

    @Override
    public Type multiply(Type data) {
        BigDecimal d = this.multiply((BigDecimal)data);
        return new Scalar(d.doubleValue());
    }

    @Override
    public Type divide(Type data) {
        BigDecimal d = this.divide((BigDecimal)data);
        return new Scalar(d.doubleValue());
    }

    @Override
    public Type plus(Type data) {
        BigDecimal d = this.add((BigDecimal)data);
        return new Scalar(d.doubleValue());
    }

    @Override
    public Type minus(Type data) {
        BigDecimal d = this.subtract((BigDecimal)data);
        return new Scalar(d.doubleValue());
    }

    @Override
    public Type remainder(Type data) {
        BigDecimal d = this.remainder((BigDecimal)data);
        return new Scalar(d.doubleValue());
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

    @Override
    public boolean sizeOf(Object object) {
        if(!(object instanceof Scalar)) return false;
        Scalar o = (Scalar) object;
        return this.equals(o);
    }

    @Override
    public int compareTo(Type object) {
        if(!(object instanceof Scalar)) return -1;
        Scalar o = (Scalar) object;
        return super.compareTo(o);
    }
    
}
