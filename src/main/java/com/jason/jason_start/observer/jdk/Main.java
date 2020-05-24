package com.jason.jason_start.observer.jdk;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public class Main {
    public static void main(String[] args) {
        RealSubject2 realSubject2 = new RealSubject2();
        RealObserver2 realObserver2 = new RealObserver2();
        realSubject2.addObserver(realObserver2);
        realSubject2.makeChanged();
    }
}
