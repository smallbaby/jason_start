package com.jason.jason_start.chapter1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@Slf4j
public class Dog implements Animal{

    @Override
    public void use() {
        log.info("Dog " + Dog.class.getSimpleName() + " 是用来看门的.");
    }
}
