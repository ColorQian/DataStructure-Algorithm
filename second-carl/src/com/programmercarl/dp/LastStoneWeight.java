package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/last-stone-weight-ii/
 * 最后一块石头的重量
 */
public class LastStoneWeight {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        int bagSize = sum / 2;
        //容量为j的背包，能装载最多的石头的重量为dp[j]
        int[] dp = new int[bagSize + 1];
        //先遍历物品，再遍历背包容量，遍历背包容量要倒序
        for (int i = 0; i < stones.length; i++) {
            for (int j = bagSize; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - dp[bagSize] - dp[bagSize];
    }
}
