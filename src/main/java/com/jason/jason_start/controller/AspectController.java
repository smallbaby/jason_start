package com.jason.jason_start.controller;

import com.jason.jason_start.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@RestController
public class AspectController {
    @Autowired
    private HelloService helloService;
    @GetMapping("/aspect")
    public Object aspect() {
        helloService.sayHello("jason");
        return "succ.";
    }
}
