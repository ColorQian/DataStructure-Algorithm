package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/D0F0SV/
 * 剑指 Offer II 104. 排列的数目
 */
public class Question104 {
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 完全背包中的排列问题
        // 先遍历背包(从小到大), 再遍历物品
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < len; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
