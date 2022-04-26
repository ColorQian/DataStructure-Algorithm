package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/a7VOhD/
 * 剑指 Offer II 020. 回文子字符串的个数
 */
public class Question20 {
    public int countSubstrings(String s) {
        int len = s.length();

        // dp[i][j] 表示若[i, j]范围内的字符串为回文的，那么dp[i][j] 为true
        boolean[][] dp = new boolean[len][len];

        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {  // "a" "aa"
                        result++;
                        dp[i][j] = true;
                    } else {
                        if (dp[i + 1][j - 1]) { // "aaa"
                            result++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return result;
    }
}
