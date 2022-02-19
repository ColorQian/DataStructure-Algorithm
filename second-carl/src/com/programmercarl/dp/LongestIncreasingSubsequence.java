package com.programmercarl.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * (最长递增/上升子序列)
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        //dp[i] 表示i之前，包括i的最长递增子序列长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //注意这里不是要dp[i] 与 dp[j] + 1进行比较，而是我们要取dp[j] + 1的最大值。
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] > result) result = dp[i];
        }
        return result;
    }
}
