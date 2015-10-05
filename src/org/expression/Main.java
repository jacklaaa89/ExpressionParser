package org.expression;

/**
 *
 * @author jacktimblin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //String scalar = "LOG(4.5) + (0.5 > x) - SUM([1,1,1;1,1,1]) + MAX([12,-3,4.5])";
        String scalar = "1.2 << 2";
        Expression e = new Expression(scalar);
        Context result = e.eval();
        System.out.format("%s = %s\n", scalar, result);
        
    }
    
}
