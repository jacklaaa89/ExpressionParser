package org.expression;

import org.expression.parser.Context;

/**
 *
 * @author Jack
 */
public class Main {
    public static void main(String[] args) {
        Expression ex = new Expression();
        ex.setExpression("var a = -[1,1]; -a++;");
        Context c = ex.eval();
        System.out.println(c);
    }
}
