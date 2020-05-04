package com.jason.jason_start.controller;

import com.jason.jason_start.chapter1.BussinessPerson;
import com.jason.jason_start.chapter1.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@RestController
public class BusinessPersonController {

    @GetMapping("/dog")
    public Object index() {
        BussinessPerson bussinessPerson = new BussinessPerson(new Dog());
        bussinessPerson.service();
        return "succ";
    }
}
