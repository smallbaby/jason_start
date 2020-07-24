package com.jason.jason_start.annotation.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Author: Jason
 * Date 2020/7/19
 */
public class One {
}

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@interface JasonSpringBootConfiguration {
    @AliasFor(
            annotation = Configuration.class
    )
    boolean proxyBeanMethods() default true;
}









