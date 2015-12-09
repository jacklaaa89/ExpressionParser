package org.expression.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A Particular URI variable and the position in the route it will be placed.
 * @author Jack Timblin
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Variables.class)
public @interface Variable {
    String name();
    int position();
}
