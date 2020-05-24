package com.jason.jason_start.observer.dispatcher.test;

import com.jason.jason_start.observer.dispatcher.Handler;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public class UserCreatedEventHandler implements Handler<UserCreatedEvent> {
    @Override
    public void onEvent(UserCreatedEvent event) {
        System.out.println("create:" + event.getUser().getUsername());
    }
}
