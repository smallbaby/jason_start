package com.jason.jason_start.controller;

import com.jason.jason_start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getuserlist")
    public Object getUserList() {
        return userService.getUserList();
    }
}
