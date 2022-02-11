package com.programmercarl.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 322.零钱兑换
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        //可以理解为完全背包的组合问题
        //先遍历物品，再遍历背包容量，遍历背包容量从小到大
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) { // 如果dp[j - coins[i]]是初始值则跳过
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        else return dp[amount];
    }
}
