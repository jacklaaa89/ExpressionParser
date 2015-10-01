package org.expression;

import java.math.BigDecimal;

/**
 *
 * @author jacktimblin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Returns a Scalar result.
        double x = Math.random();
        System.out.println(x);
        
        String scalar = "LOG(4.5) + (0.5 > x) - SUM([1,1,1;1,1,1]) + MAX([12,-3,4.5])";
        Context result = new Expression(scalar).addVariable("x", x).eval();
        System.out.format("%s = %s\n", scalar, result);
        
    }
    
}
