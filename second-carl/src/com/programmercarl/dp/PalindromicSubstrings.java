package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 回文子串的个数
 */
public class PalindromicSubstrings {
    /**
     * 方法一：暴力遍历
     */
    public int countSubstrings1(String s) {
        int len = s.length();
        if (len == 1) return 1;
        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (isPalindromic(i, j, s)) {
                    result++;
                }
            }
        }
        return result;
    }
    public boolean isPalindromic(int start, int end, String s) {
        if (end - start == 1) return true;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end - 1)) return false;
            start++;
            end--;
        }
        return true;
    }

    /**
     * 方法二:动态规划
     */
    public int countSubstrings(String s) {
        int len = s.length();
        if (len == 1) return 1;
        int result = 0;

        //dp[i][j] 表示 区间[i, j]内的子串是否是回文串,若是则dp[i][j]为true
        boolean[][] dp = new boolean[len][len];

        //根据递推公式确定遍历顺序
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {         //如果是 "a","aa" 的情况
                        result++;
                        dp[i][j] = true;
                    } else {                  // j - i > 1 ("aaa")
                        if (dp[i + 1][j - 1]) {  //看区间内部是不是回文串
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
