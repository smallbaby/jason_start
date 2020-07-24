package com.jason.jason_start.netty.deep;

/**
 * Author: Jason
 * Date 2020/6/1
 */
public class Test {
    public static void main(String[] args) {
        new MasterServer(new MasterHandler()).start(8009);
    }
}
