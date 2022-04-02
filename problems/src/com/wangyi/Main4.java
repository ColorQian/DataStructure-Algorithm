package com.wangyi;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            if (grid[i][0] == grid[i - 1][0]) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 2;
            }
        }

        for (int i = 1; i < n; i++) {
            if (grid[0][i] == grid[0][i - 1]) {
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                dp[0][i] = dp[0][i - 1] + 2;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int left = grid[i][j] == grid[i][j - 1] ? 1 : 2;
                int up = grid[i][j] == grid[i - 1][j] ? 1 : 2;

                dp[i][j] = Math.min(dp[i][j - 1] + left, dp[i - 1][j] + up);
            }
        }

        System.out.println(dp[m - 1][n - 1]);
    }
}
