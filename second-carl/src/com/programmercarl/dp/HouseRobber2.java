package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int result1 = houseRobber(nums, 0, nums.length - 2);  //考虑首，不考虑尾
        int result2 = houseRobber(nums, 1, nums.length - 1);  //不考虑首，考虑尾
        return Math.max(result1, result2);
    }

    //注意区间的开闭原则
    public int houseRobber(int[] nums, int start, int end) {
        if (end - start == 1) return Math.max(nums[start], nums[start + 1]);
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int j = 2; j <= end; j++) {
            dp[j] = Math.max(dp[j - 2] + nums[j], dp[j - 1]);
        }
        return dp[end];
    }
}
