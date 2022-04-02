package com.test;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int MaxSubset(int[] nums) {
        int len = nums.length;
        // dp[i] 表示以下标i为结尾的序列，上升子序列的长度为dp[i]
        int[] dp = new int[nums.length];
        int maxLen = 0;
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (maxLen < dp[i]) maxLen = dp[i];
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence mAx = new LongestIncreasingSubsequence();
        int[] nums = new int[]{8,9,1,5,3,7,30,18};

        System.out.println(mAx.MaxSubset(nums));
    }
}
