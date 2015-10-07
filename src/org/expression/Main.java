package org.expression;

/**
 *
 * @author jacktimblin
 */
public class Main {
    public static void main(String[] args) {
       Expression e = new Expression("COLUMN([1,2,3], [2.5,3.5], 1)");
       Context<Vector> r = e.eval();
       System.out.println(r);
    }
}
