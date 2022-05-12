package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/qJnOS7/
 * 剑指 Offer II 095. 最长公共子序列
 */
public class Question95 {
    public int longestCommonSubsequence(String text1, String text2) {

        // dp[i][j] 表示两个字符串最长公共子序列的长度
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) != text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
