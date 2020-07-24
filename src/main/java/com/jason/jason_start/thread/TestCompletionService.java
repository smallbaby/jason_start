package com.jason.jason_start.thread;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Author: Jason
 * Date 2020/6/6
 */
public class TestCompletionService {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test2() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CompletionService<Long> completionService = new ExecutorCompletionService<>(executorService);
        final int groupNum = 10000000 / 100;
        for (int i = 0; i < 100; i++) {
            int start = (i - 1) * groupNum + 1, end = i * groupNum;
            completionService.submit(new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    Long sum = 0l;
                    for (int j = 0; j < end; j++) {
                        sum += j;
                    }
                    return sum;
                }
            });
        }
        long result = 0;
        try {
            for (int i = 0; i < 100; i++) {
                result += completionService.take().get();

            }
            System.out.println("xxxxx=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test1() {
        Long startTime = System.currentTimeMillis();
        ExecutorService exs = Executors.newFixedThreadPool(5);
        try {
            int taskCount = 10;
            List<Integer> list = new ArrayList<>();
            List<Future<Integer>> futureList = new ArrayList<>();
            CompletionService<Integer> completionService = new ExecutorCompletionService<>(exs);
            for (int i = 0; i < taskCount; i++) {
                Future<Integer> future = completionService.submit(new Task(i + 1));
                futureList.add(future);
            }
            for (int i = 0; i < taskCount; i++) {
                Integer result = completionService.take().get();
                System.out.println("任务i==" + result + " 完成" + new Date());
                list.add(result);
            }
            System.out.println("list=" + list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exs.shutdown();
        }
    }

    static class Task implements Callable<Integer> {
        Integer i;

        public Task(Integer i) {
            this.i = i;
        }

        @Override
        public Integer call() throws Exception {
            if (i == 5) {
                Thread.sleep(5000);
            } else {
                Thread.sleep(1000);
            }
            System.out.println("线程: " + Thread.currentThread().getName() + " 任务i = " + i + "执行完成.");
            return i;
        }
    }
}
