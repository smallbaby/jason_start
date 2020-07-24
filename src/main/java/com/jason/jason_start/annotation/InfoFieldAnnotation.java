package com.jason.jason_start.annotation;

import java.lang.annotation.*;

/**
 * Author: Jason
 * Date 2020/7/18
 */
@Documented
@Target(ElementType.FIELD) // 作用到field上的注解
@Retention(RetentionPolicy.RUNTIME)
public @interface InfoFieldAnnotation {
    enum Status {FIRST, SECOND}

    Status value() default Status.FIRST;
}

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface InfoMethodAnnotation {
    String author() default "baidu";

    String website() default "baidu.com";

    int version() default 1;

}
