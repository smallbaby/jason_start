package com.jason.jason_start.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public class RealSubject implements Subject {

    private List<Observer> observerList = new ArrayList<>();
    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notice() {
        for (Observer ob :
                observerList) {
            ob.update();

        }
    }
}
