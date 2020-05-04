package com.jason.jason_start.common;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@Slf4j
public class MyInterceptor implements Interceptor {

    @Override
    public boolean before() {
        log.info("before...");
        return true;
    }

    @Override
    public void after() {
        log.info("after...");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        log.info("around before...");
        Object object = invocation.proceed();
        log.info("around after....");
        return object;
    }

    @Override
    public void afterReturning() {
        log.info("afterReturning....");
    }

    @Override
    public void afterThrowing() {
        log.info("afterThrowing....");
    }

    @Override
    public boolean userAround() {
        return true;
    }
}
