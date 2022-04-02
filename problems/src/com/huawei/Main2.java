package com.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        int m = in.nextInt();
        int n = in.nextInt();
        int startRow = in.nextInt();
        int startCol = in.nextInt();
        int endRow = in.nextInt();
        int endCol = in.nextInt();
        int lakeNum = in.nextInt();
        int[][] lake = new int[lakeNum][2];
        for (int i = 0; i < lakeNum; i++) {
            lake[i][0] = in.nextInt();
            lake[i][1] = in.nextInt();
        }

        int[][] grid = new int[m][n];
        for (int i = 0; i < lake.length; i++) {
            int row = 0;
            int col = 0;
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    row = lake[i][j];
                }
                else col = lake[i][j];
            }
            grid[row][col] = 1;
        }

        // 初始化dp 数组
        int[][] dp = new int[m][n];
        for (int i = startRow; i <= endRow; i++) {
            if (grid[i][startCol] == 1) break;
            else dp[i][startCol] = 1;
        }
        for (int j = startCol; j <= endCol; j++) {
            if (grid[startRow][j] == 1) break;
            else dp[startRow][j] = 1;
        }

        for (int i = startRow + 1; i <= endRow; i++) {
            for (int j = startCol + 1; j <= endCol; j++) {
                if (grid[i][j] == 1) continue;

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        int path = endRow - startRow + endCol - startCol;
        System.out.println(dp[endRow][endCol] + " " + path);
    }
    
}
