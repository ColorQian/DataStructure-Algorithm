package com.jianzhioffer2.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 查找数组中重复的数字
 */
public class RepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int[] hash = new int[nums.length];
        Arrays.fill(hash, -1);

        for (int i = 0; i < nums.length; i++) {
            if (hash[nums[i]] != -1) {
                return hash[nums[i]];
            }
            hash[nums[i]] = nums[i];

        }
        return -1;
    }
}
