package com.jason.jason_start.future;

import java.util.concurrent.*;

/**
 * 方法get() 将阻止执行，直到任务完成
 * get（long，TimeUnit） 可以设置超时.
 * Author: Jason
 * Date 2020/7/13
 */
public class FutureTest {
    public static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Integer> future = calculate1(10);
        while (!future.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }
        System.out.println(future.get());
    }

    public static Future<Integer> calculate(Integer input) {
        return threadPool.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }

    public static Future<Integer> calculate1(Integer input) {
        return threadPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                final CountDownLatch latch = new CountDownLatch(1);
                int x = input * input;
                latch.countDown();
                return x;
            }
        });
    }

}
