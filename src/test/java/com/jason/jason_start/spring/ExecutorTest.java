package com.jason.jason_start.spring;

import com.jason.jason_start.common.CommonLog;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author: Jason
 * Date 2020/5/10
 */
public class ExecutorTest {
    public void executorTest() {
        ScheduledExecutorService schedulePool = Executors.newScheduledThreadPool(10);
        schedulePool.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date() + "hello");
            }
        }, 3000, 10, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        System.out.println(new Date());
        ScheduledExecutorService schedulePool = Executors.newScheduledThreadPool(10);
        // 延迟几秒运行，间隔几秒
        // 上一个开始+ 延迟 = scheduleWithFixedDelay
        // scheduleAtFixedRate 根据上一个任务开始计算下一个的开始时间.
        schedulePool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                CommonLog.info("hello");
                System.out.println(new Date() + "hello");
                try {
                    Thread.sleep(1000);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }
}
