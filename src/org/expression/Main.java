/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.expression;

/**
 *
 * @author jacktimblin
 */
public class Main {
    public static void main(String[] args) {
       Expression e = new Expression("[1, 2+2]");
       Context<Vector> r = e.eval();
       System.out.println(r);
    }
}
