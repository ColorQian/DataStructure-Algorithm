package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 最长公共子序列
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        //dp[i][j] 表示 下标i-1的text1 和 下标为j-1的text2最长公共子序列长度
        int[][] dp = new int[str1.length + 1][str2.length + 1];

        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[str1.length][str2.length];
    }
}
