package org.expression.output;

import org.expression.Context;

/**
 * The default output. Prints the context to the console.
 * @author Jack Timblin
 */
public class ConsoleOutput implements OutputListener {
    @Override
    public void print(Context context) {
        System.out.println(context);
    }
}
