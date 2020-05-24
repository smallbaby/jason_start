package com.jason.jason_start.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Jason
 * Date 2020/5/24
 */
public class Main {
    public static void main(String[] args) {
        // 20##
        // 20 {0~9} {0~9}
        // 20\d\d  \d 表示任意一个数字 \d* 任意个数字 \d+ 至少一个数字 \d? 匹配0个或一个字符 \d{3,5} \d{3,}
        // 20\\d\\d
        // 任意一个特殊字符 \&
        // \w 一个字母、数字、下划线 \W 非字符
        // \s 一个空格字符 \S 非空格
        // \d 匹配一个数字  \D 一个非数字
        // \d{3,4}-\d{7,8}
        // 非贪婪匹配  加 ?
        is20xx();
        isAny();
        isPhone();
        getGroup();
        getHourMS();
        getZero();
    }

    private static void getZero() {
        String rex = "(\\d*?)(0+)";
        Pattern pattern = Pattern.compile(rex);
        Matcher m = pattern.matcher("1230000");
        if (m.matches()) {
            System.out.println(m.group(2));
        }
    }

    private static void getHourMS() {
        String rex = "(\\d{2}):(\\d{2}):(\\d{2})";
        Pattern p = Pattern.compile(rex);
        Matcher m = p.matcher("23:01:59");
        if (m.matches()) {
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
        }
    }

    /**
     * 分组获取匹配的内容.
     */
    public static void getGroup() {
        String rex = "(\\d{3,4})-([1-9])\\d{6,7}";
        Pattern p = Pattern.compile(rex);
        Matcher m = p.matcher("010-1234567");
        if (m.matches()) {
            String q1 = m.group(2);
            System.out.println(q1);
        }

    }

    public static void isPhone() {
        String rex = "\\d{3,4}-[1-9]\\d{6,7}";
        System.out.println("phone:" + "010-1234567".matches(rex));
        System.out.println("phone:" + "0100-123456.78".matches(rex));
    }

    public static void is20xx() {
        String regex = "20\\d\\d";
        System.out.println("2019".matches(regex));
        System.out.println("2020".matches(regex));
        System.out.println("1020".matches(regex));
    }

    public static void isAny() {
        String re2 = "a\\&c";
        System.out.println("a&c".matches(re2));
        System.out.println("a-c".matches(re2));
        System.out.println("a&&c".matches(re2));
    }
}
