package com.jason.jason_start.common;

import io.swagger.models.auth.In;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: Jason
 * @date 2020/5/4
 */
public class Invocation {
    private Object[] params;
    private Method method;
    protected Object target;
    public Invocation(Object target, Method method, Object[] params) {
        this.target = target;
        this.method = method;
        this.params = params;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }

}
