package com.programmercarl.array;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new LinkedList<>();

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        int num = 1;
        int target = m * n;
        while (num <= target) {
            for (int i = left; i<= right; i++) {  //left -> right
                result.add(matrix[top][i]);
                num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) { // top -> bottom
                result.add(matrix[i][right]);
                num++;
            }
            right--;

            for (int i = right; i >= left && num <= target; i--) { // right -> left
                                                                    //for循环中的 num <= target 条件是防止集合重复添加
                result.add(matrix[bottom][i]);
                num++;
            }
            bottom--;

            for (int i = bottom; i >= top && num <= target; i--) { // bottom -> top
                                                                    //for循环中的 num <= target 条件是防止集合重复添加
                result.add(matrix[i][left]);
                num++;
            }
            left++;
        }
        return result;
    }
}
