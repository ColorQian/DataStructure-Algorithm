package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/21dk04/
 * 剑指 Offer II 097. 子序列的数目
 */
public class Question97 {
    public int numDistinct(String s, String t) {
        if (t.length() == 0) return 1;

        int m = s.length();
        int n = t.length();

        // 1. dp[i][j] 表示以 i-1 为结尾的s, 得到以 j-1为结尾的t 总共的方案数为dp[i][j]
        int[][] dp = new int[m + 1][n + 1];

        // 2. dp数组初始化
        for (int i = 0; i <= m; i++) dp[i][0] = 1;

        // 3. 确定遍历顺序
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 4. 状态转移方程
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // dp[i - 1][j - 1]表示从前一个状态转移过来,相当于删除s、t的当前字符
                    // dp[i - 1][j] 表示不考虑s的当前字符, 看之前有几种方案
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // 若匹配不上, 就看删除s的当前字符, 也就是之前有几种子序列方案
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
