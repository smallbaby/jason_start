package com.jason.jason_start.spring;

/**
 * Author: Jason
 * Date 2020/7/16
 */
public class BinaryArrayTest {
    public static void main(String[] args) {
        int[][] a = new int[3][4];
        a[0][0] = 1;
        a[0][1] = 3;
        a[0][2] = 5;
        a[0][3] = 11;

        a[1][0] = 2;
        a[1][1] = 4;
        a[1][2] = 6;
        a[1][3] = 13;

        a[2][0] = 3;
        a[2][1] = 7;
        a[2][2] = 9;
        a[2][3] = 15;
        for (int i = 0; i < 16; i ++)
            System.out.println(i + "在" + test(a, i));
    }

    public static String test(int[][] a, int key) {

        int i = 0, j = 0, col = a[0].length, row = a.length; // 列  行

        for (; i < row && j < col; ) {
            if (key == a[i][j]) {
                return i + "--" + j;
            }

            if (key < a[i][j]) { // 小于当前，说明不存在
                return "not found.";
            }
            int tmp_i =i, tmp_j = j;
            if (key > a[tmp_i][col - 1]) { // 大于这一行最后一个，说明不在这一行，行号+1 ， < 最后一个，说明不在最后一列, 总列-1
                i++;
            } else if (key < a[tmp_i][col - 1]){
                col--;
            } else {
                return i + "--" + j;
            }
            if (key > a[row - 1][tmp_i]) { // 大于这列最后一个，说不在这一列，列号+1  < 最后一个，说明不在这一行
                j++;
            } else if (key < a[row - 1][tmp_i]) {
                row--;
            }else {
                return i +"---" + j;
            }
        }
        return "not found.";
    }
}
