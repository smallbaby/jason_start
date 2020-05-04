package com.jason.jason_start.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@Aspect
@Slf4j
public class MyAspect {
    @Pointcut("execution(* com.jason.jason_start.service.impl.HelloServiceImpl.sayHello(..))")
    public void pointCut() {

    }
    @Before("pointCut()")
    public void before() {
        log.info("before...");
    }
    @After("pointCut()")
    public void after() {
        log.info("after.");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        log.info("afterReturning.");
    }
    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        log.info("afterThrowing.");
    }

}
