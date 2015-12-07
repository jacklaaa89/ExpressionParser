package org.expression.http;

/**
 * A wrapper for a HTTP Header.
 * @author Jack Timblin
 */
public class Header {
    
    /**
     * The name of the header
     */
    public String name;
    
    /**
     * The value of the header.
     */
    public String value;
    
    /**
     * The default value of the header to use if this header is not defined.
     */
    public String defaultValue;
    
    /**
     * Gets the value of this header.
     * @return the header value.
     */
    public String getValue() {
        return value == null ? defaultValue : value;
    }
    
    /**
     * Gets the name of the header
     * @return the name of the header.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Sets the value of this header.
     * @param value the value.
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
     * Initialises a new header with a name and a default value.
     * @param name the name of the header
     * @param defaultValue the default value to use incase it is not provided.
     */
    public Header(String name, String defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }
    
    /**
     * Determines if this header has at least one concrete value to provide.
     * @return true if the default value or value are set, false otherwise.
     */
    public boolean isDefined() {
        return defaultValue != null || value != null;
    }
    
    @Override
    public String toString() {
        return name + ": " + ((!this.isDefined()) ? " Undefined" : this.getValue());
    }
    
}
