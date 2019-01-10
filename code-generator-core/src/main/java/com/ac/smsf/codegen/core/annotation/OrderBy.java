package com.ac.smsf.codegen.core.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface OrderBy {

    int order() default 1;

    boolean asc() default true;

}
