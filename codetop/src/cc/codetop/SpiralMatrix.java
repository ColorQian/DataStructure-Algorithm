package cc.codetop;

import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; int n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        int target = m * n;
        int count = 1;
        List<Integer> result = new ArrayList<>();
        while (count <= target) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                count++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                count++;
            }
            right--;

            for (int i = right; i >= left && count <= target; i--) {
                result.add(matrix[bottom][i]);
                count++;
            }
            bottom--;

            for (int i = bottom; i >= top && count <= target; i--) {
                result.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = count;
                count++;
            }
        }

        List<Integer> list = SpiralMatrix.spiralOrder(matrix);
        System.out.println(list);

    }
}
