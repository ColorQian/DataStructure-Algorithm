package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/JEj789/
 * 剑指 Offer II 091. 粉刷房子
 */
public class Question91 {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        int result = Integer.MAX_VALUE;
        if (m == 1) {
            return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        }

        int[][] dp = new int[m][n];
        dp[0] = costs[0];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][j];
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][j];
                }

                if (i == m - 1) {
                    result = Math.min(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}
