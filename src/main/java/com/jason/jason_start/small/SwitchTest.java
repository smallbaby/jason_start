package com.jason.jason_start.small;

import java.util.Objects;

/**
 * Author: Jason
 * Date 2020/6/4
 */
public class SwitchTest {
    public static void main(String[] args) {
        String x = null;
        switchTest(x);
    }

    private static void switchTest(String x) {

        switch (Objects.requireNonNull(x)) {
            case "1":
            case "2":
                System.out.println("1");
            default:
                System.out.println("2");
        }
    }
}
