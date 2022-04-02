package com.test;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int count = traversal(matrix, i, j);
                    result += count;
                }
            }
        }
        System.out.println(result);
    }

    private static int traversal(int[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        int count = 0;
        for (int k = j - 1; k >= 0; k--) {
            if (matrix[i][k] == 1) {
                count++;
                break;
            }
        }
        for (int k = j + 1; k < n; k++) {
            if (matrix[i][k] == 1) {
                count++;
                break;
            }
        }

        for (int t = i - 1; t >= 0; t--) {
            if (matrix[t][j] == 1) {
                count++;
                break;
            }
        }
        for (int t = i + 1; t < m; t++) {
            if (matrix[t][j] == 1) {
                count++;
                break;
            }
        }
        return count;
    }
}
