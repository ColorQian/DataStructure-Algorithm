package com.programmercarl.array;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int target = n * n;
        int num = 1;
        while (num <= target) {
            for (int i = left; i <= right; i++) result[top][i] = num++; //left -> right
            top++;

            for (int i = top; i <= bottom; i++) result[i][right] = num++;  // top -> bottom
            right--;

            for (int i = right; i >= left; i--) result[bottom][i] = num++; // right -> left
            bottom--;

            for (int i = bottom; i >= top; i--) result[i][left] = num++;  // bottom -> top
            left++;
        }
        return result;
    }
}
