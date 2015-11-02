package org.expression.output;

import org.expression.Context;
import org.expression.parser.ExpressionException;

/**
 * The default output. Prints the context to the console.
 * @author Jack Timblin
 */
public class ConsoleOutput implements OutputListener {
    @Override
    public void print(Context context) {
        System.out.println(context);
    }

    @Override
    public boolean exceptionThrown(ExpressionException e, Context context) {
        System.err.println(e.getMessage());
        return true;
    }
}
