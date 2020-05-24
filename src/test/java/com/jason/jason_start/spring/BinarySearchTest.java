package com.jason.jason_start.spring;

import org.junit.jupiter.api.Test;

/**
 * Author: Jason
 * Date 2020/5/23
 */
public class BinarySearchTest {
    @Test
    public void bsTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 9};
        int a = 4;
        System.out.println(binarySearch(a, array));
    }

    /**
     * 二分查找
     *
     * @param key   key
     * @param array a
     */
    private Integer binarySearch(int key, int[] array) {
        int low = 0; // 第一个坐标
        int high = array.length - 1; // 最后一个下标
        int middle = 0;
        if (key < array[low] || low > high || key > array[high]) {
            return -1;
        }
        while (low <= high) {
            middle = (low + high) / 2;
            if (array[middle] == key) {
                return middle;
            } else if (array[middle] > key) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
