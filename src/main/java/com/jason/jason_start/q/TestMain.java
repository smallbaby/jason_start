package com.jason.jason_start.q;

import java.util.concurrent.BlockingQueue;

/**
 * Author: Jason
 * Date 2020/5/5
 */
public class TestMain {
    public static void main(String[] args) {
    }
}


class Product implements Runnable {
    private BlockingQueue<String> queue;
    public Product(BlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while (true) {
                queue.put(produce());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String produce() {
        return "hello";
    }
}
class Consumer implements Runnable {
    private BlockingQueue<String> queue;
    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void consume(String msg) {
        System.out.println(msg);
    }
}