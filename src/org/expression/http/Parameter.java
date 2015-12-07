package org.expression.http;

/**
 * A wrapper class for a URL Query Parameter
 * @author Jack Timblin
 */
public class Parameter {
    
    /**
     * The name of the parameter.
     */
    private final String name;
    
    /**
     * The value of the parameter.
     */
    private final String value;
    
    /**
     * Initialises a new Parameter with a name and value.
     * @param name the name of the parameter
     * @param value the value.
     */
    public Parameter(String name, String value) {
        this.name = name;
        this.value = value;
    }
    
    /**
     * Gets the name of the parameter.
     * @return the name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Gets the value of the parameter.
     * @return the value.
     */
    public String getValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return name + ": " + ((value != null) ? value : "");
    }
    
}
