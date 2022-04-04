package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/submissions/
 * 顺时针打印数组
 */
public class Problem29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        int count = 0;
        int[] res = new int[m * n];
        while (count < m * n) {

            for (int i = left; i <= right; i++) {
                res[count++] = matrix[top][i];
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res[count++] = matrix[i][right];
            }
            right--;

            for (int i = right; i >= left && count < m * n; i--) {
                res[count++] = matrix[bottom][i];
            }
            bottom--;

            for (int i = bottom; i >= top && count < m * n; i--) {
                res[count++] = matrix[i][left];
            }
            left++;
        }
        return res;
    }
}
