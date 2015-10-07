package org.expression;

/**
 *
 * @author jacktimblin
 */
public class Main {
    public static void main(String[] args) {
       Expression e = new Expression("[1, 2^3]");
       Context<Vector> r = e.eval();
       System.out.println(r);
    }
}
