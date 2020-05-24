package com.jason.jason_start.observer.jdk;

import java.util.Observable;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public class RealSubject2 extends Observable {
    public void makeChanged() {
        setChanged();
        notifyObservers();
    }
}
