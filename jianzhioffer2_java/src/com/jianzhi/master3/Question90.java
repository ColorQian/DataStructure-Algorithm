package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/PzWKhm/
 * 剑指 Offer II 090. 环形房屋偷盗
 */
public class Question90 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        int money1 = helper(nums, 0, len - 2);  // 不偷最后一间
        int money2 = helper(nums, 1, len - 1);  // 不偷第一间

        return Math.max(money1, money2);
    }

    public int helper(int[] nums, int start, int end) {
        if (end - start == 1) return Math.max(nums[start], nums[end]);

        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
