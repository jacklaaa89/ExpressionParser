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
        Matrix m = new Matrix(new double[][]{{1,2,3},{4,5,6}});
        Scalar s = m.sum();
        System.out.println(s);
    }
}
