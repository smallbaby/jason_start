package com.jason.jason_start.observer;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public class Mian {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        RealObserver observer = new RealObserver();
        subject.attach(observer);
        subject.notice();
    }
}
