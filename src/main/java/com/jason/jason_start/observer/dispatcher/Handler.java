package com.jason.jason_start.observer.dispatcher;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public interface Handler<E extends Event> {
    void onEvent(E event);
}
