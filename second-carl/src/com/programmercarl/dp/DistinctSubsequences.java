package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/distinct-subsequences/
 * 不同的子序列
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (t.length() == 0) return 1;
        if (s.length() == 0) return 0;

        //dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int j = 0; j < t.length(); j++) dp[0][j] = 0;
        for (int i = 0; i < s.length(); i++) dp[i][0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {    //若当前字符匹配上
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; //dp[i - 1][j - 1]表示用s[i - 1]匹配, dp[i - 1][j]表示不用s[i - 1]匹配
                } else {     //若当前字符匹配不上
                    dp[i][j] = dp[i - 1][j];   //取dp[i - 1][j]表示 不用s[i - 1]匹配
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
