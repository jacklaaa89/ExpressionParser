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
     */
    public void print(Context context);
    
    /**
     * Triggered when an return statement is used in the script.
     * @param context the returned context.
     */
    public void onReturn(Context context);
    
    /**
     * Triggered when a syntax error occurs in the script.
     * @param message the error message.
     * @param line the line where the error occurred.
     * @param charPositionInLine the position in that line where the error occurred.
     */
    public void syntaxError(String message, int line, int charPositionInLine);
}
