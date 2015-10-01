package org.expression;

import java.util.List;
import java.util.Locale;

/**
 * An encapsulation of a Function.
 * @author Jack Timblin
 */
public abstract class Function {
    
    /**
     * The name of the function.
     */
    private final String name;
    
    /**
     * The amount of parameters this function expects to receive.
     */
    private final int amountOfExpectedParameters;
    
    /**
     * Initializes a new Function.
     * @param name the name of the function.
     * @param amountOfExpectedParameters the amount of parameters this function
     * expects to receive.
     */
    public Function(String name, int amountOfExpectedParameters) {
        this.name = name;
        this.amountOfExpectedParameters = amountOfExpectedParameters;
    }
    
    /**
     * Gets the name of the function in uppercase.
     * @return the name of the function.
     */
    public String getName() {
        return this.name.toUpperCase(Locale.ROOT);
    }
    
    /**
     * Gets the amount of parameters that this function expects to receive.
     * @return the amount of parameters this function expects to receive.
     */
    public int getAmountOfExpectedParameters() {
        return this.amountOfExpectedParameters;
    }
    
    /**
     * Performs the evaluation of this function and returns the computed result.
     * @param args the parameters which were provided.
     * @return the result to the computation.
     */
    public abstract Type eval(List<Type> args);
    
}
