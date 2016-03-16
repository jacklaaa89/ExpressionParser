package org.expression.computation;

import org.expression.Type;

/**
 * An interface which is used to Evaluate operator statements.
 * @author Jack Timblin
 * @param <R> The return type from the Evaluator.
 */
public interface Evaluator<R extends Type> {
    /**
     * Evaluates a particular operation expression. <br><br>
     * As Scalar, Vector and Matrix all implement Arithmetic and Type, both the left and right sides 
     * can be cast into a more concrete class if the type of the class can accurately be known.
     * @param left The left half of the expression, this is supplied as an Arithmetic
     * as a lot of Arithmetic functions are defined here.
     * @param right The right hand side of the expression, also supplied as an Arithmetic, this will be null in postfix/prefix operations.
     * @return The evaluated solution to the expression.
     * @throws ArithmeticException if performing the evaluation causes an ArithmeticException.
     */
    public R eval(Arithmetic left, Arithmetic right) throws ArithmeticException;
    
}
