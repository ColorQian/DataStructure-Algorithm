package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/GzCJIP/
 * 剑指 Offer II 088. 爬楼梯的最少成本
 */
public class Question88 {
    public int minCostClimbingStairs(int[] cost) {
        // 1. dp[i] 表示爬上i阶楼梯, 需要耗费最少的体力为dp[i]
        int[] dp = new int[cost.length];

        // 2. dp数组初始化
        dp[0] = cost[0];
        dp[1] = cost[1];

        // 3. 遍历顺序, 从前向后
        for (int i = 2; i < cost.length; i++) {
            // 4. 状态转移方程
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        int len = dp.length;
        return Math.min(dp[len - 1], dp[len - 2]);
    }
}
