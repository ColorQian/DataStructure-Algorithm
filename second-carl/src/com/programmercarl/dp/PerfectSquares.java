package com.programmercarl.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class PerfectSquares {
    /**
     * 物品即为一个个 平方数, 背包容量则为n
     */
    public int numSquares(int n) {
        if (n == 1) return 1;
        //dp[j] 表示筹齐整数n, 所需要的最少的完全平方数个数为dp[j]
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n / 2; i++) {   //i <= n/2 体现了一个优化过程
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
