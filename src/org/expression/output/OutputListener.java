package org.expression.output;

import org.expression.Context;

/**
 * Interface used to get output from when the 'print' keyword is used.
 * @author Jack Timblin
 */
public interface OutputListener {
    /**
     * Triggered when the 'print' keyword is found in the parse tree.
     * @param context The evaluated statement to be printed.
     * @param lineNo The line which the print statement was found.
     * @param expression The expression to be printed.
     * @param charPositionInLine The position in the line where the print statement begins.
     */
    public void print(Context context, int lineNo, String expression, int charPositionInLine);
}
