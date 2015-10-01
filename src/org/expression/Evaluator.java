package org.expression;

/**
 * An interface which is used to Evaluate operator statements.
 * @author Jack Timblin
 * @param <R> The return type from the Evaluator.
 */
public interface Evaluator<R extends Type> {
    /**
     * Evaluates a particular operation expression. <br/><br/>
     * In the case that we have a Vector/Matrix in an expression with a Scalar value
     * The Scalar value is always defined as the right value (as the position of the scalar 
     * in an expression with a Vector/Matrix does not change the result). In the case of two Scalar 
     * values, the positions they we defined in the original expression is maintained.<br/><br/>
     * As Scalar, Vector and Matrix all implement Arithmetic and Type, both the left and right sides 
     * can be cast into a more concrete class if the type of the class can accurately be known.
     * @param left The left half of the expression, this is supplied as an Arithmetic
     * as a lot of Arithmetic functions are defined here.
     * @param right The right hand side of the expression, also supplied as an Arithmetic.
     * @return The evaluated solution to the expression.
     * @throws ArithmeticException if performing the evaluation causes an ArithmeticException.
     */
    public R eval(Arithmetic left, Arithmetic right) throws ArithmeticException;
}
