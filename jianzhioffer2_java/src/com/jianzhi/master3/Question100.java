package com.jianzhi.master3;

import java.util.List;

/**
 * https://leetcode.cn/problems/IlPe0q/
 * 剑指 Offer II 100. 三角形中最小路径之和
 */
public class Question100 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (i == j && j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int num : dp[size - 1]) {
            res = Math.min(num, res);
        }
        return res;
    }
}
