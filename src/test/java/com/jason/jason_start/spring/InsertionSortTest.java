package com.jason.jason_start.spring;

import org.junit.jupiter.api.Test;

/**
 * Author: Jason
 * Date 2020/5/23
 */
public class InsertionSortTest {
    @Test
    public void inserSortTest() {
        int[] ins = {2, 4, 5, 1, 23, 11, 78, 34};
//        int[] ins2 = sort(ins);
//        for (int num : ins2) {
//            System.out.println(num);
//        }
        sort2(ins);
    }

    private int[] sort2(int[] ins) {
        int len = ins.length;
        if (len < 2) return ins;
        int pos = 1;
        while (pos < len) {
            for (int i = pos; i > 0; i--) {
                if (ins[i] < ins[i - 1]) {
                    int temp = ins[i -1];
                    ins[i - 1] = ins[i];
                    ins[i] = temp;
                } else {
                    break;
                }
            }
            pos ++;
        }
        for (int a: ins) {
            System.out.print(a + "\t");

        }
        return ins;
    }


    private int[] sort(int[] ins) {
        for (int i = 0; i < ins.length; i++) {
            for (int j = i; j > 0; j--) {
                if (ins[j] < ins[j-1]) {
                    int temp = ins[j - 1];
                    ins[j - 1] = ins[j];
                    ins[j] = temp;
                }
            }
        }
        return ins;
    }
}
