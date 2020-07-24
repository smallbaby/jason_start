package com.jason.jason_start.annotation;

import java.lang.annotation.*;

/**
 * annotation.
 * 1、创建注解
 * 2、元注解（基本注解）
 *
 * @Retention、 表示这个注解的存活时间  RetentionPolicy.SOURCE 源码  RetentionPolicy.CLASS 编译 RetentionPolicy.RUNTIME 运行时
 * @Documented 文档
 * @Target 目标的意思，标识注解运用的地方，当一个注解被@Target注解时，说明注解被限定l了运用的场景，比如类上、方法上。、变量上、注解
 * @Inherited、 继承的意思，父类被注解，子类无注解，自动集成父类的注解
 * @Repeatable 可重复
 * 注解的属性： 也叫成员变量,没有方法
 * 函数式编程 - 》 方便Lambda
 * 提取和处理annotation的代码统称为APT（Annotation Processing Tool)
 * @AliasFor 为注解属性声明别名 value attribute
 *
 * Author: Jason
 * Date 2020/7/18
 */

// 函数式接口注解 ,具有一个方法的普通接口
@FunctionalInterface
interface Runnable {
    public abstract void run();
}

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FirstAnnotation {
    int id();
    String msg();
    String name() default "";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface One {
    String value();
}

@interface Empty{}

@Empty
@One("one.")
@FirstAnnotation(id=1, msg="first")
class A {

}

class B extends A {

}
/// ///////////////////  /////////
// 一个人既是程序员又是产品经理又是画家
@interface Persons {
    Person[] value();
}

@Repeatable(Persons.class)
@interface Person{
    String role() default "";
}


@Person(role = "artist")
@Person(role = "coder")
class SuperMan {

}


