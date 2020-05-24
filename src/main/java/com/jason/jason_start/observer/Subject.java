package com.jason.jason_start.observer;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public interface Subject {
    // 订阅
    void attach(Observer observer);
    // 取消订阅
    void detach(Observer observer);
    // 通知
    void notice();
}
