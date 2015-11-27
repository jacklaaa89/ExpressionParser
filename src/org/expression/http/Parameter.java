/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.expression.http;

/**
 *
 * @author Jack
 */
public class Parameter {
    private final String name;
    private final String value;
    
    public Parameter(String name, String value) {
        this.name = name;
        this.value = value;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return name + ": " + ((value != null) ? value : "");
    }
    
}
