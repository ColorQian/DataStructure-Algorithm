package com.programmercarl.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * 最长连续递增子序列
 */
public class LongestContinuousIncreaseSub {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;
        // dp[i] 表示截止到下标为i的数组，其最长连续递增的子序列长度为dp[i]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            if (dp[i] > result) result = dp[i];
        }
        return result;
    }
}
