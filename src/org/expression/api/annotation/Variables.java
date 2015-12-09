package org.expression.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Variable Container Annotation class which is used to make the Variable
 * annotation repeatable. 
 * @see Variable
 * @author Jack Timblin
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Variables {
    Variable[] value() default {};
}
