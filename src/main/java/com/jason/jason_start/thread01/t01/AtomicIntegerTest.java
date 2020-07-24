package com.jason.jason_start.thread01.t01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: Jason
 * Date 2020/6/7
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.get());
    }
}
