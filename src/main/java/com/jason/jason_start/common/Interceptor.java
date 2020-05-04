package com.jason.jason_start.common;

import java.lang.reflect.InvocationTargetException;

/**
 * @author: Jason
 * @date 2020/5/4
 */
public interface Interceptor {
    boolean before();
    void after();
    Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;
    void afterReturning();
    void afterThrowing();
    boolean userAround();
}
