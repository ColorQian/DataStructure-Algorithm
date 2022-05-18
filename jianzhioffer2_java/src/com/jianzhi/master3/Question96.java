package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/IY6buf/
 * 剑指 Offer II 096. 字符串交织
 *
 * 参考：https://leetcode.cn/problems/interleaving-string/solution/lei-si-lu-jing-wen-ti-zhao-zhun-zhuang-tai-fang-ch/
 */
public class Question96 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) return false;

        // 1.搞清楚dp数组的含义
        // dp[i][j] 表示若 s1的前 i 个字符 能与 s2的前 j 个字符 组成s3的前 i + j 个字符
        // 则dp[i][j] 为true
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 2. dp数组初始化
        dp[0][0] = true;
        for (int i = 1; i <= m && s1.charAt(i - 1) == s3.charAt(i - 1); i++) dp[i][0] = true;
        for (int i = 1; i <= n && s2.charAt(i - 1) == s3.charAt(i - 1); i++) dp[0][i] = true;

        // 3. 遍历顺序
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 4. 状态转移方程
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m][n];
    }
}
