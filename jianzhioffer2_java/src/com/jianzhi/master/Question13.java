package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/O4NDxx/
 * 剑指 Offer II 013. 二维子矩阵的和
 */
public class Question13 {

    int[][] sums;
    public Question13(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) return;

        sums = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int resSum = sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1]
                - sums[row2 + 1][col1] + sums[row1][col1];
        return resSum;
    }
}
