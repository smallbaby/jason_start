package com.jason.jason_start.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * 将firstannotation标签 贴到这个类上
 * Author: Jason
 * Date 2020/7/18
 */
@One(value = "hello")
@FirstAnnotation(id=1, msg = "first")
public class TestOne {
    public static void main(String[] args) {
        System.out.println(new TestOne());
        TestOne t = new TestOne();
        t.test();
        t.hello();
        Annotation[] ans = TestOne.class.getAnnotations();
        FirstAnnotation a = TestOne.class.getAnnotation(FirstAnnotation.class);
        System.out.println(a.id());
        System.out.println(a.msg());
        System.out.println(a);
        Arrays.asList(ans).forEach(x -> System.out.println(x));
    }
    @Deprecated
    public void test() {
    }
    public void hello() {

    }
}
