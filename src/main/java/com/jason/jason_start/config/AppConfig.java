package com.jason.jason_start.config;

import com.jason.jason_start.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Jason
 * @date 2020/5/4
 */
public class AppConfig {
    public User initUser() {
        User u = new User();
        u.setId(1L);
        u.setName("zk");
        u.setNote("helloworld");
        return u;
    }
}
