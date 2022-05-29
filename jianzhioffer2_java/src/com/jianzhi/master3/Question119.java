package com.jianzhi.master3;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/WhsWhI/
 * 剑指 Offer II 119. 最长连续序列
 */
public class Question119 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int[] dp = new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp, 1);

        int result = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
                result = Math.max(result, dp[i]);
            } else if (nums[i] == nums[i - 1]) {
                dp[i] = dp[i - 1];
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
}
