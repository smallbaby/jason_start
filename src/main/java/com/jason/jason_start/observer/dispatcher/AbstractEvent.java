package com.jason.jason_start.observer.dispatcher;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public class AbstractEvent implements Event {
    @Override
    public Class<? extends Event> getType() {
        return getClass();
    }
}
