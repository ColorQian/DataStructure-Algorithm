package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/submissions/
 * 剑指 Offer 47. 礼物的最大价值
 */
public class Problem47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) return grid[0][0];

        for (int i = 1; i < m; i++) grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < n; i++) grid[0][i] += grid[0][i - 1];

        int choice = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                choice = Math.max(grid[i - 1][j], grid[i][j - 1]);
                grid[i][j] = choice + grid[i][j];
            }
        }

        return grid[m - 1][n - 1];
    }
}
