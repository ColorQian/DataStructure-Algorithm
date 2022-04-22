package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/tvdfij/
 * 剑指 Offer II 012. 左右两边子数组的和相等
 */
public class Question12 {
    public int pivotIndex(int[] nums) {
        int len = nums.length;

        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            // 当前这个 元素i 后半部分的和等于前半部分的和
            if (totalSum - sum == sum - nums[i]) {
                return i;
            }
        }

        return -1;
    }
}
