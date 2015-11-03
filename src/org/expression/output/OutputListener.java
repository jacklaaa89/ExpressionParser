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
     * @param context the context up to the point of the exception.
     */
    public void onReturn(Context context);
}
