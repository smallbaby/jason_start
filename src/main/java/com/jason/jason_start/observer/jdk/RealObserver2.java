package com.jason.jason_start.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public class RealObserver2 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("hello");
    }
}
