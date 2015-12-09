package org.expression.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to determine what HTTP methods a particular action accepts.
 * @author Jack Timblin
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface HttpMethod {
    org.expression.http.RequestType[] value() default { };
}
