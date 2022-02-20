package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 */
public class DeleteOperationForTwoStrings {
    /**
     方法一：先求字符串的最长公共子序列
     然后两个字符串的长度减去最长公共子序列即可
     */
    public int minDistance1(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return len1 + len2 - dp[len1][len2] * 2;
    }

    /**
     * 方法二：考虑删除word1 和/或 word2
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        /**
         dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，
         想要达到相等，所需要删除元素的最少次数。
         */
        int[][] dp = new int[len1 + 1][len2 + 1];

        //dp[][] 数组初始化
        for (int i = 1; i <= len1; i++) dp[i][0] = i;
        for (int j = 1; j <= len2; j++) dp[0][j] = j;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2,
                            Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                }
            }
        }
        return dp[len1][len2];
    }
}
