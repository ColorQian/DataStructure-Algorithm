package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/coin-change-2/
 * 零钱兑换2
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        //1.dp[j]表示 填满容量为 j 的背包，共有dp[j] 种方法
        int[] dp = new int[amount + 1];

        //2.初始化dp数组,填充容量为0的背包有一种方法
        dp[0] = 1;

        //3.确定遍历顺序
        //完全背包先遍历物品，再遍历背包(遍历背包要从小到大)
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //4.确定状态转移方程
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
