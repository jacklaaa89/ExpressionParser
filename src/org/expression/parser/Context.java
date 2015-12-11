package org.expression.parser;

import org.expression.Scalar;
import org.expression.Type;
import org.expression.structure.Matrix;
import org.expression.structure.Vector;

/**
 * An encapsulation of an expression result, either a fragment in the expression or
 * the overall expression itself. 
 * i.e (1 + 1) - 3 would have two contexts, one for the (1 + 1) and one
 * for the 2 - 3 (the evaluated form of the previous context is on the left.)
 * A context can have no evaluated result and in this case the context is classed as 'empty'.
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
    private String expression;
    
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
     * Determines if this context is empty, i.e contains no evaluated result.
     * @return <b>TRUE</b> if the evaluated result was empty, <b>FALSE</b> otherwise.
     */
    public boolean isEmptyContext() {
        return value == null;
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
     * Wraps the expression in start and end string values.
     * Useful for applying parenthesis to expressions, as they are
     * stripped during the parsing process to account for the
     * order of operations.
     * @param start the value to append to the start of the expression
     * @param end  the value to append to the end.
     */
    protected void wrapExpression(String start, String end) {
        this.expression = start + expression + end;
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
        String v = (value != null) ? this.value.toString() : "[Empty Context]";
        return this.expression + " = " + v;
    }
    
}
