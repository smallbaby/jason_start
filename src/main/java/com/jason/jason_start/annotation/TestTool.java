package com.jason.jason_start.annotation;

import java.lang.reflect.Method;

/**
 * 测试类
 * Author: Jason
 * Date 2020/7/18
 */
public class TestTool {
    public static void main(String[] args) {
        NoBug noBug = new NoBug();
        Class clazz = noBug.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        StringBuffer log = new StringBuffer(); // 日志
        int errNum = 0; // 记录异常的次数
        for (Method m: methods
             ) {
            if (m.isAnnotationPresent(CheckBug.class)) {
                try {
                    m.setAccessible(true); // 避免访问安全检查异常
                    m.invoke(clazz, null);
                } catch (Exception e) {
                    errNum++;
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error. ");
                    log.append("\n\r caused by");
                    log.append(e.getCause());
                    log.append("\n\r");
                    log.append(e.getCause());
                    log.append("\n\r");
                }
            }
        }
        log.append(clazz.getSimpleName());
        log.append(" has  ");
        log.append(errNum);
        log.append(" error.");
        System.out.println(log.toString());
    }
}
