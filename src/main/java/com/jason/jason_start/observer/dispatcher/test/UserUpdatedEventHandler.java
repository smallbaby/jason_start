package com.jason.jason_start.observer.dispatcher.test;

import com.jason.jason_start.observer.dispatcher.Handler;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public class UserUpdatedEventHandler implements Handler<UserUpdatedEvent> {
    @Override
    public void onEvent(UserUpdatedEvent event) {
        System.out.println("update:" + event.getUser().getUsername());
    }
}
