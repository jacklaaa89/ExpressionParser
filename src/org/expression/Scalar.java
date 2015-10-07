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
    
    public Scalar(String value) {
        this(Double.parseDouble(value));
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
    public Arithmetic multiply(Type data) {
        Handler h = (Handler) (Scalar o1, MathContext mcon) -> {
            return (Scalar) this.multiply((Type)o1);
        };
        if(data instanceof Scalar) {
            BigDecimal d = this.multiply((BigDecimal)data, mc);
            return new Scalar(d.doubleValue(), mc);
        }
        return (Arithmetic) data.apply(h);
    }

    @Override
    public Arithmetic divide(Type data) {
        Handler h = (Handler) (Scalar o1, MathContext mcon) -> {
            return (Scalar) this.divide((Type)o1);
        };
        if(data instanceof Scalar) {
            BigDecimal d = this.divide((BigDecimal)data, mc);
            return new Scalar(d.doubleValue(), mc);
        }
        return (Arithmetic) data.apply(h);
    }

    @Override
    public Arithmetic plus(Type data) {
        if(data instanceof Scalar) {
            BigDecimal d = this.add((BigDecimal)data, mc);
            return new Scalar(d.doubleValue(), mc);
        }
        Handler h = (Handler) (Scalar o1, MathContext mcon) -> {
            return (Scalar) this.plus(o1);
        };
        return (Arithmetic) data.apply(h);
    }

    @Override
    public Arithmetic minus(Type data) {
        Handler h = (Handler) (Scalar o1, MathContext mcon) -> {
            return (Scalar) this.minus(o1);
        };
        if(data instanceof Scalar) {
            BigDecimal d = this.subtract((BigDecimal)data, mc);
            return new Scalar(d.doubleValue(), mc);
        }
        return (Arithmetic) data.apply(h);
    }

    @Override
    public Arithmetic remainder(Type data) {
        if(data instanceof Scalar) {
            BigDecimal d = this.remainder((BigDecimal)data, mc);
            return new Scalar(d.doubleValue(), mc);
        }
        Handler h = (Handler) (Scalar o1, MathContext mcon) -> {
            return (Scalar) this.remainder((Type)o1);
        };
        return (Arithmetic) data.apply(h);
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

    @Override
    public Arithmetic bitwiseLeft(Scalar value) {
        return new Scalar(this.movePointLeft(value.intValueExact()).doubleValue(), mc);
    }

    @Override
    public Arithmetic bitwiseRight(Scalar value) {
        return new Scalar(this.movePointRight(value.intValueExact()).doubleValue(), mc);
    }

    @Override
    public Arithmetic neg() {
        return new Scalar(this.negate().doubleValue(), mc);
    }

    @Override
    public Arithmetic pos() {
        return new Scalar(this.abs(mc).doubleValue(), mc);
    }

    @Override
    public Arithmetic absolute() {
        return new Scalar(this.abs(mc).doubleValue(), mc);
    }
    
}
