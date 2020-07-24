package com.jason.jason_start.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jason
 * Date 2020/5/25
 */
public class App {
    public static void main(String[] args) {
        GlmapperGeneric glmapperGeneric = new GlmapperGeneric();
        glmapperGeneric.set("test");
        String test = (String) glmapperGeneric.get();
        System.out.println(test);
        GlmapperGeneric<String> stringGlmapperGeneric = new GlmapperGeneric<>();
        stringGlmapperGeneric.set("xxx");
        String s = stringGlmapperGeneric.get();
        System.out.println(s);
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        int a = countLegs(dogs);
        System.out.println(a);

    }

   private <T> void test(List<? super T> dst, List<T> src) {
        for (T t : src) {
            dst.add(t);
        }
   }

    static int countLegs1 (List< Animal > animals ){
        int retVal = 0;
        for ( Animal animal : animals )
        {
            retVal += 1;
        }
        return retVal;
    }
    private static int countLegs(List<? extends Animal> animals) {
        int retVal = 0;
        for (Animal animal :
                animals) {
            retVal += 1;
        }
        return retVal;
    }

}
class Animal {
    public void call() {

    }
}

class Dog extends Animal {
    int x = 1;
}

class GlmapperGeneric<T> {
    private T t;
    public void set(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }
}
