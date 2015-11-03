/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.expression.parser;

import org.expression.Context;

/**
 *
 * @author Jack
 */
public class ExpressionException extends RuntimeException {
    private final Context context;
    public ExpressionException(Context c) {
        this.context = c;
    }
    public Context getContext() {
        return context;
    }
}
