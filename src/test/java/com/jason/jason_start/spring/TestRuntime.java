package com.jason.jason_start.spring;

import java.io.IOException;

/**
 * Author: Jason
 * Date 2020/7/15
 */
public class TestRuntime {
    public static void main(String[] args) {
        try {
            String x = "echo 123 > /Users/zhangkai/tmp/b.txt";
            String []cmdarry ={"/bin/bash", "-c", x};
            Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", x}).waitFor();
            System.out.println("执行完成");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
