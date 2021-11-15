package com.programmercarl.hashtable;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    //方法一：暴力匹配
    public int[] twosum1(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    //方法二：使用HashMap
    public int[] twosum2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                result[0] = map.get(temp);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

}
