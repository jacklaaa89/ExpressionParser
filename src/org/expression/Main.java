package org.expression;

import org.expression.parser.Context;

/**
 *
 * @author Jack
 */
public class Main {
    public static void main(String[] args) {
        Expression ex = new Expression();
        ex.setExpression("[2,RANDOM()] + 1;");
        Context c = ex.eval();
        System.out.println(c.getValue());
    }
}
