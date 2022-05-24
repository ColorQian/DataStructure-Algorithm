package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/fpTFWP/
 * 剑指 Offer II 112. 最长递增路径
 */
public class Question112 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int longest = 0;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 计算以[i, j]为起点的递增路径的长度
                int length = dfs(matrix, result, i, j);
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }

    public int dfs(int[][] matrix, int[][] result, int i, int j) {
        // 如果大于0, 说明以[i, j]为起点的递增路径已经计算过,直接返回
        if (result[i][j] > 0) {
            return result[i][j];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int length = 1;
        // 遍历 [i, j] 的四邻域, 寻找以四个邻域为起点的最长递增路径
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
                int path = dfs(matrix, result, x, y);
                length = Math.max(length, path + 1);
            }
        }

        // 更新以 [i, j] 为起点的 递增路径的长度
        result[i][j] = length;
        return length;
    }
}
