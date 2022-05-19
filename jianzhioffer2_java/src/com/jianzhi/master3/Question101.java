package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/NUPfPr/
 * 剑指 Offer II 101. 分割等和子集
 */
public class Question101 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 1) return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;

        int bagSize = sum / 2;
        int[] dp = new int[bagSize + 1];

        // 0-1背包 先遍历物品 再遍历背包
        // 遍历背包要按照从大到小的顺序
        for (int i = 0; i < len; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[bagSize] == bagSize;
    }
}
