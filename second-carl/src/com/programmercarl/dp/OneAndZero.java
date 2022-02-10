package com.programmercarl.dp;

/**
 *https://leetcode-cn.com/problems/ones-and-zeroes/
 * 一和零
 * (本质还是0-1背包问题，先遍历物品，再遍历背包容量)
 * (只不过由常见的一个维度，转化为了两个维度)
 */
public class OneAndZero {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {  //遍历物品
            int zeroNum = 0;
            int oneNum = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zeroNum++;
                else oneNum++;
            }

            for (int i = m; i >= zeroNum; i--) {  //遍历背包容量，且从大到小遍历
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
