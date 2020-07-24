package com.jason.jason_start.annotation.selector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Author: Jason
 * Date 2020/7/19
 */
@Import({Square.class, Circular.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@Configuration
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String s: beans
             ) {
            System.out.println(s);
        }
    }
}
