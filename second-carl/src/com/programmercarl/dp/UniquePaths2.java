package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 不同路径2(有障碍)
 */
public class UniquePaths2 {
    //*****此题注意区分dp数组 和 obstacleGrid数组*****
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;  //(0,0)位置有障碍,可用路径为0

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //dp[i][j] 表示走到(i,j) 位置共有多少种路径
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {  //初始化第一列
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }

        for (int j = 1; j < n; j++) {  //初始化第一行(初始化第一列时,(0,0)已经初始化过，所以从(0,1)开始)
            if (obstacleGrid[0][j] != 1) {
                dp[0][j] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
