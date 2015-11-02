package org.expression.output;

import org.expression.Context;
import org.expression.parser.ExpressionException;

/**
 * Interface used to get output from when the 'print' keyword is used.
 * @author Jack Timblin
 */
public interface OutputListener {
    /**
     * Triggered when the 'print' keyword is found in the parse tree.
     * @param context The evaluated statement to be printed.
     */
    public void print(Context context);
    
    /**
     * Triggered when an exception is thrown in the script.
     * @param e the exception that was thrown.
     * @param context the context up to the point of the exception.
     * @return whether the exception should be thrown after this point.
     */
    public boolean exceptionThrown(ExpressionException e, Context context);
}
