package com.jason.jason_start.observer;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public class RealObserver implements Observer{
    @Override
    public void update() {
        System.out.println("接到了通知.");
    }
}
