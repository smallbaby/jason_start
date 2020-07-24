package com.jason.jason_start.annotation;

/**
 * Author: Jason
 * Date 2020/7/18
 */
public class NoBug {

    @CheckBug
    public void hell() {
        System.out.println(1/0);
    }
    @CheckBug
    @Deprecated
    public void test1() {
        System.out.println("test1");
    }

    public void test2() {
        System.out.println("test2");
    }

    public static void main(String[] args) {
        new NoBug().test1();
    }
}
