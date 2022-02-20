package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 最长回文子序列
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len == 1) return 1;

        //dp[i][j] 表示在区间[i, j]内，最长的回文子序列长度为dp[i][j]
        int[][] dp = new int[len][len];

        //dp数组初始化
        for (int i = 0; i < len; i++) dp[i][i] = 1;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
