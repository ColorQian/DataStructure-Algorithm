package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/YaVDxD/
 * 剑指 Offer II 102. 加减的目标值
 */
public class Question102 {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (Math.abs(target) > sum) return 0;
        if ((sum + target) % 2 == 1) return 0;

        int bagSize = (sum + target) / 2;
        // 填满容量为 j 的背包, 有dp[j]种方法
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        // 0-1 背包, 先遍历物品, 再遍历背包容量
        // 遍历背包容量要从大到小
        for (int i = 0; i < len; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
