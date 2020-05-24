package com.jason.jason_start.observer.dispatcher.test;

import com.jason.jason_start.observer.dispatcher.AbstractEvent;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public class UserCreatedEvent extends AbstractEvent {
    private User user;
    public UserCreatedEvent(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
}
