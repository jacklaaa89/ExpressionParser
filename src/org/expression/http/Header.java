package org.expression.http;

/**
 *
 * @author Jack
 */
public class Header {
    
    public String name;
    public String value;
    public String defaultValue;
    
    public String getValue() {
        return value == null ? defaultValue : value;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public Header(String name, String defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }
    
    public boolean isDefined() {
        return defaultValue != null || value != null;
    }
    
    @Override
    public String toString() {
        return name + ": " + ((!this.isDefined()) ? " Undefined" : this.getValue());
    }
    
}
