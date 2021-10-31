package com.programmercarl.array;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class Problem6 {
    public int[][] generateMatrix(int n) {
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int[][] result = new int[n][n];

        int number = 1;
        while (number <= n * n) {
            for (int i = left; i <= right; i++) {
                result[top][i] = number++;
            }
            top++;

            for (int i = top; i <= bottom ; i++) result[i][right] = number++;
            right--;

            for (int i = right; i >= left; i--) result[bottom][i] = number++;
            bottom--;

            for (int i = bottom; i >= top; i--) result[i][left] = number++;
            left++;
        }
        return result;
    }

}
