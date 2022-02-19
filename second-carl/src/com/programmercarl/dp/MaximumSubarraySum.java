package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 最大子数组和
 */
public class MaximumSubarraySum {
    /**
     * 解法一：贪心算法
     */
    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) return nums[0];

        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > result) result = sum;
            if (sum < 0) sum = 0;
        }
        return result;
    }

    /**
     * 解法二:动态规划
     */
    public int maxSubArray2(int[] nums) {
        if (nums.length == 1) return nums[0];
        //dp[i] 表示下标为i的数组，最大子数组和为dp[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (result < dp[i]) result = dp[i];
        }
        return result;
    }
}
