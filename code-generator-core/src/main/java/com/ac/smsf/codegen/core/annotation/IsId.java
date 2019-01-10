package com.ac.smsf.codegen.core.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 标识是否一个id列
 *
 * @author s.c.gao
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface IsId {
}
