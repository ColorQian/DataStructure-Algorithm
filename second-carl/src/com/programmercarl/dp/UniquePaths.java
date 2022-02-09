package com.programmercarl.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 不同路径(从左上角走到右下角)
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        //dp[i][j] 表示(i, j) 位置共有多少种路径
        int[][] dp = new int[m][n];

        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
