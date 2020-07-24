package com.jason.jason_start.start;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author: Jason
 * Date 2020/7/19
 */
public class Main2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = Main1.class;
        Method main = clazz.getDeclaredMethod("main1", String[].class);
        main.invoke(null, new Object[]{null});
        System.out.println(Main2.class.getClassLoader());
    }
}
