package com.jianzhi.master3;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/omKAoA/
 * 剑指 Offer II 094. 最少回文分割
 */
public class Question94 {
    public int minCut(String s) {
        int len = s.length();

        // 表示isPal[i][j]若为true, 则[i, j]范围内为回文串
        boolean[][] isPal = new boolean[len][len];

        // 根据isPal[i + 1][j - 1]确定遍历顺序
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {  // 只有一个字符
                    isPal[i][j] = true;
                } else {       // 多个字符
                    if (s.charAt(i) == s.charAt(j)) {
                        // 考虑两个字符 或 大于两个字符的情况
                        if (j - i == 1 || isPal[i + 1][j - 1]) {
                            isPal[i][j] = true;
                        }
                    }
                }
            }
        }

        //  dp[i] 表示字符串的前缀 s[0..i] 的最少分割次数
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int j = 0; j < len; j++) {
            if (isPal[0][j]) {  // 如果[0, j] 范围内是回文串, 不需要分割
                dp[j] = 0;
            } else {      // [0, j] 范围内是不是回文串, 需要分割
                for (int i = 0; i < j; i++) {  // 遍历找[0, ...j - 1]的最小分割次数
                    if (isPal[i + 1][j])  // 同时要保证[i+1, j]是一个回文串
                        // 相当于把[0, j] 拆分成[0, i], [i + 1, j]
                        dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}
