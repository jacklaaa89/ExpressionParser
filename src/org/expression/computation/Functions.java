package org.expression.computation;

import java.math.MathContext;
import java.math.RoundingMode;
import org.expression.Scalar;


/**
 * A collection of handlers for common arithmetic functions.
 * i.e log, tan, sin etc.
 * @author Jack Timblin
 */
public enum Functions {
    
    /**
     * The Natural Logarithm.
     */
    LOG {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(Math.log(o1.doubleValue()));
            };
        }
    },
    /**
     * The Base 10 Logarithm .
     */
    LOG10 {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(Math.log10(o1.doubleValue()), mc);
            };
        }
    },
    /**
     * The natural logarithm of x + 1. i.e log(x + 1)
     */
    LOG1P {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(Math.log1p(o1.doubleValue()), mc);
            };
        }
    },
    /**
     * Trigonometric Sine function (Opposite / Hypotenuse) . 
     */
    SIN {
        @Override
        public Handler get() {
            return (Handler) new Handler() {
                @Override
                public Scalar handle(Scalar o1, MathContext mc) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
        }
    },
    /**
     * Trigonometric Cosine function (Adjacent / Hypotenuse)  .
     */
    COS {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(Math.cos(Math.toRadians(o1.doubleValue())));
            };
        }
    },
    /**
     * Trigonometric Tangent function (Opposite / Adjacent) . 
     */
    TAN {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(Math.tan(Math.toRadians(o1.doubleValue())), mc);
            };
        }
    },
    /**
     * The inverse Sine (sin^-1).
     */
    ASIN {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(Math.asin(Math.toDegrees(o1.doubleValue())), mc);
            };
        }
    },
    /**
     * The inverse Tangent (tan^-1).
     */
    ATAN {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(Math.atan(Math.toDegrees(o1.doubleValue())), mc);
            };
        }
    },
    /**
     * The inverse Cosine (cos^-1).
     */
    ACOS {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(Math.acos(Math.toDegrees(o1.doubleValue())), mc);
            };
        }
    },
    /**
     * The hyperbolic Sine.
     */
    SINH {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(Math.sinh(o1.doubleValue()), mc);
            };
        }
    },
    /**
     * The hyperbolic Cosine.
     */
    COSH {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(Math.cosh(o1.doubleValue()), mc);
            };
        }
    },
    /**
     * The hyperbolic Tangent.
     */
    TANH {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(Math.tanh(o1.doubleValue()), mc);
            };
        }
    },
    /**
     * Converts a number into Radians.
     */
    RAD {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(Math.toRadians(o1.doubleValue()), mc);
            };
        }
    },
    /**
     * Converts a number into Degrees.
     */
    DEG {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(Math.toDegrees(o1.doubleValue()), mc);
            };
        }
    },
    /**
     * The absolute value of a number without regards to the sign (+/-)
     */
    ABS {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(o1.abs(mc).doubleValue(), mc);
            };
        }
    },
    /**
     * Rounds to the nearest whole number with rounding towards negative infinity.
     */
    FLOOR {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(o1.setScale(0, RoundingMode.FLOOR).doubleValue(), mc);
            };
        }
    },
    /**
     * Rounds to the nearest whole number with rounding towards positive infinity.
     */
    CEILING {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(o1.setScale(0, RoundingMode.CEILING).doubleValue(), mc);
            };
        }
    },
    /**
     * Negates a value i.e computes (-Scalar)
     */
    NEGATE {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(o1.negate(mc).doubleValue(), mc);
            };
        }
    },
    /**
     * Plus a value. i.e computes (+Scalar)
     */
    PLUS {
        @Override
        public Handler get() {
            return (Handler) (Scalar o1, MathContext mc) -> {
                return new Scalar(o1.abs(mc).doubleValue(), mc);
            };
        }
    };
    
    /**
     * returns the handler attached with an enum value.
     * @return the handler.
     */
    public abstract Handler get();
    
}
