package org.expression;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 *
 * @author jacktimblin
 */
public class Scalar extends BigDecimal implements Arithmetic  {
    
    public static final Scalar ZERO = new Scalar(0d);
    public static final Scalar ONE  = new Scalar(1d);
    
    private final MathContext mc;
    
    public Scalar(double val) {
        super(val);
        this.mc = MathContext.DECIMAL32;
    }
    
    public Scalar(BigInteger i, int precision) {
        super(i, precision);
        this.mc = MathContext.DECIMAL32;
    }
    
    public Scalar(double val, MathContext mc) {
        super(val, mc);
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
    public Type multiply(Type data) {
        BigDecimal d = this.multiply((BigDecimal)data, mc);
        return new Scalar(d.doubleValue());
    }

    @Override
    public Type divide(Type data) {
        BigDecimal d = this.divide((BigDecimal)data, mc);
        return new Scalar(d.doubleValue(), mc);
    }

    @Override
    public Type plus(Type data) {
        BigDecimal d = this.add((BigDecimal)data, mc);
        return new Scalar(d.doubleValue(), mc);
    }

    @Override
    public Type minus(Type data) {
        BigDecimal d = this.subtract((BigDecimal)data, mc);
        return new Scalar(d.doubleValue(), mc);
    }

    @Override
    public Type remainder(Type data) {
        BigDecimal d = this.remainder((BigDecimal)data, mc);
        return new Scalar(d.doubleValue(), mc);
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
    
    @Override
    public Scalar apply(Functions handle) {
        return this.apply(handle.get());
    }
    
}
