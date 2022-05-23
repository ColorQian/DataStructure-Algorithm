package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/ZL6zAn/
 * 剑指 Offer II 105. 岛屿的最大面积
 *
 * 参考题解: https://labuladong.github.io/algo/4/29/106/
 */
public class Question105 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 计算岛屿最大面积, 并更新最大值
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        // 越界直接返回
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        if (grid[i][j] == 0) return 0;

        // 淹没陆地
        grid[i][j] = 0;

        return dfs(grid, i - 1, j) +
                dfs(grid, i + 1, j) +
                dfs(grid, i, j - 1) +
                dfs(grid, i, j + 1) + 1;
    }
}
