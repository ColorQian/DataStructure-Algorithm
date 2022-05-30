package com.leetcode.hot;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * 5. 最长回文子串
 */
public class LC05 {
    public String longestPalindrome(String s) {
        int len = s.length();

        // 如果[i, j]范围内的子串是回文的, 那么dp[i][j]为true
        boolean[][] dp = new boolean[len][len];
        // dp数组初始化
        for (int i = 0; i < len; i++) dp[i][i] = true;

        int left = 0;
        int right = 0;
        int maxLen = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {  // "aa"
                        dp[i][j] = true;
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            left = i;
                            right = j;
                        }
                    } else {  // "aba" ...
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            if (j - i + 1 > maxLen) {
                                maxLen = j - i + 1;
                                left = i;
                                right = j;
                            }
                        }
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
