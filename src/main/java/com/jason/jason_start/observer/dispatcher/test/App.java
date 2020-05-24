package com.jason.jason_start.observer.dispatcher.test;

import com.jason.jason_start.observer.dispatcher.EventDispatcher;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public class App {
    public static void main(String[] args) {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerHandler(UserCreatedEvent.class, new UserCreatedEventHandler());
        dispatcher.registerHandler(UserUpdatedEvent.class, new UserUpdatedEventHandler());
        User user = new User();
        user.setUsername("hello");
        dispatcher.dispatch(new UserCreatedEvent(user));
        dispatcher.dispatch(new UserUpdatedEvent(user));
    }
}
