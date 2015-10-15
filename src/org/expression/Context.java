package org.expression;

import org.expression.structure.Matrix;
import org.expression.structure.Vector;

/**
 * An encapsulation of an expression result, either a fragment in the expression or
 * the overall expression itself. 
 * i.e (1 + 1) - 3 would have two contexts, one for the (1 + 1) and one
 * for the 2 - 3 (the evaluated form of the previous context is on the left.)
 * @author Jack Timblin
 * @param <T> The expected result object.
 */
public class Context<T extends Type> {
    
    /**
     * The evaluated result from this context.
     */
    private final T value;
    
    /**
     * The line number which this context is placed.
     */
    private final int lineNo;
    
    /**
     * The position in that line where the expression starts.
     */
    private final int charPositionInLine;
    
    /**
     * The expression which was evaluated.
     */
    private final String expression;
    
    /**
     * Initializes a context, providing it with a result from this evaluation.
     * @param value the value from a single context in the expression.
     * @param lineNo the line where the expression was found.
     * @param charPositionInLine the position in that line where the expression was found.
     * @param expression the expression
     */
    public Context(T value, int lineNo, int charPositionInLine, String expression) {
        this.value = value;
        this.expression = expression;
        this.lineNo = lineNo;
        this.charPositionInLine = charPositionInLine;
    }
    
    /**
     * Determines if the result from this context was a Vector.
     * @return <b>TRUE</b> if the evaluated result was a Vector, <b>FALSE</b> otherwise.
     */
    public boolean isArray() {
        return (value instanceof Vector);
    }
    
    /**
     * Determines if the result from this context was a Matrix.
     * @return <b>TRUE</b> if the evaluated result was a Matrix, <b>FALSE</b> otherwise.
     */
    public boolean isMatrix() {
        return (value instanceof Matrix);
    }
    
    /**
     * Determines if the result from this context was a Scalar.
     * @return <b>TRUE</b> if the evaluated result was a Scalar, <b>FALSE</b> otherwise.
     */
    public boolean isScalar() {
        return (value instanceof Scalar);
    }
    
    /**
     * Retrieve the evaluated value from this context.
     * @return the evaluated result.
     */
    public T getValue() {
        return value;
    }
    
    /**
     * gets the line number the expression was found.
     * @return the line number.
     */
    public int getLineNo() {
        return this.lineNo;
    }
    
    /**
     * gets the position in the line where the expression was found.
     * @return the position in the line the expression was found.
     */
    public int getCharPositionInLine() {
        return this.charPositionInLine;
    }
    
    /**
     * the expression which was evaluated in this context.
     * @return the expression which was evaluated.
     */
    public String getExpression() {
        return this.expression;
    }
    
    @Override
    public String toString() {
        String v = this.value.toString();
        return v;
    }
    
}
