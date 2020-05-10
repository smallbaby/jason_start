package com.jason.jason_start.leetcode;

import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Jason
 * Date 2020/5/10
 * input: nums = [2, 7, 11, 15] target = 9
 * because nums[0] + nums[1] = 2+7=9
 * return [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(twoSum(nums, 9));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer>  map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];  // 9 - 2 = 7
            if (map.containsKey(sub)) {
                return new int[] {i, map.get(sub)};
            }
            map.put(nums[i], i); // 3, 1
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
