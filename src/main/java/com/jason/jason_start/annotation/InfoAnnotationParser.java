package com.jason.jason_start.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Author: Jason
 * Date 2020/7/18
 */
public class InfoAnnotationParser {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = InfoAnnotationParser.class.getClassLoader().loadClass(InfoMain.class.getName());
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InfoFieldAnnotation.class)) {
                InfoFieldAnnotation infoFieldAnnotation = field.getAnnotation(InfoFieldAnnotation.class);
                System.out.println(field.getName() + "---" + infoFieldAnnotation.value());
            }
        }
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(InfoMethodAnnotation.class)) {
                InfoMethodAnnotation infoMethodAnnotation = method.getAnnotation(InfoMethodAnnotation.class);
                System.out.println("method:" + method.getName() + "\nauthor:" + infoMethodAnnotation.author()
                +"\nwebsite:" + infoMethodAnnotation.website() + "\nversion:" + infoMethodAnnotation.version());
            }
        }
    }
}
