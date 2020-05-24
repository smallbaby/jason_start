package com.jason.jason_start.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * 知识点：滑动窗口
 * Author: Jason
 * Date 2020/5/24
 */
public class MinimumCoveringSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String xx = minWindow(s, t); // expect： BANC
        System.out.println(xx);
    }

    //判断所有的 value 是否为 0
    private static boolean match(Map<Character, Integer> map) {
        for (Integer value : map.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }

    private static String minWindow(String s, String t) {
        Map<Character, Integer> hashMap = new HashMap<>();
        //遍历字符串 t，初始化每个字母的次数
        for (int i = 0; i < t.length(); i++) {
            char char_i = t.charAt(i);
            hashMap.put(char_i, hashMap.getOrDefault(char_i, 0) + 1);
        }
        int flag = t.length();
        int left = 0;
        int right = 0;
        int ans_left = 0; //保存最小窗口的左边界
        int ans_right = -1; //保存最小窗口的右边界
        int ans_len = Integer.MAX_VALUE; //当前最小窗口的长度
        while (right < s.length()) {
            char char_right = s.charAt(right);
            if (hashMap.containsKey(char_right)) {
                hashMap.put(char_right, hashMap.get(char_right) - 1);
                while (match(hashMap)) {
                    int tmp_len = right - left + 1;
                    if (tmp_len < ans_len) {
                        ans_left = left;
                        ans_right = right;
                        ans_len = tmp_len;
                    }
                    char key = s.charAt(left);
                    if (hashMap.containsKey(key)) {
                        hashMap.put(key, hashMap.get(key) + 1);
                    }
                    left++;
                }
            }
            right++;
        }
        return s.substring(ans_left, ans_right + 1);
    }
}
