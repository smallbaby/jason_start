package com.jason.jason_start.service.impl;

import com.jason.jason_start.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if (name == null || name.trim() == "") {
            throw new RuntimeException("parameter is null !!!!");
        }
        log.info("say hello." + name);
    }
}
