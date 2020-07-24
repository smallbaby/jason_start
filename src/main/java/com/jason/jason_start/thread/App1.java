package com.jason.jason_start.thread;

/**
 * Author: Jason
 * Date 2020/7/20
 */
public class App1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        test();
        System.out.println("xxxx:" + (System.currentTimeMillis() - start));
    }

    private static void test() {
        System.out.println("hello");
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                }
                System.out.println("world");
            }
        }.start();
    }
}
