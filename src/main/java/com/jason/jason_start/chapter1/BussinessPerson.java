package com.jason.jason_start.chapter1;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author: Jason
 * @date 2020/5/4
 */
@ToString
public class BussinessPerson implements Person {
    @Autowired
    Animal animal;

    // Qualifier 避免歧义
    public BussinessPerson(@Autowired @Qualifier Animal animal) {
        this.animal = animal;
    }

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
