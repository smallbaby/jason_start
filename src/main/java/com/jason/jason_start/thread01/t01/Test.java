package com.jason.jason_start.thread01.t01;

/**
 * Author: Jason
 * Date 2020/5/5
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getName());
        MyThread thread = new MyThread();
        thread.start();
        thread.sleep(1000);
        new Thread(new MyThread2()).start();
        thread.sleep(1000);
        new MyThread3("a").start();
        new MyThread3("b").start();
        new MyThread3("c").start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int time = (int) (Math.random()*1000);
                Thread.sleep(time);
                System.out.println("Run ==" + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("running...");
    }
}
class MyThread3 extends Thread {
    private int count = 5;

    public MyThread3(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count --;
            System.out.println("由 " + this.getName() + " 计算, count:" + count);
        }
    }
}