package org.expression.parser;

/**
 *
 * @author Jack
 */
public class ExpressionException extends RuntimeException {
    private final Context context;
    public ExpressionException(Context c) {
        this.context = c;
    }
    public Context getContext() {
        return context;
    }
}
