package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/cyJERH/
 * 剑指 Offer II 092. 翻转字符
 */
public class Question92 {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();

        // dp[i][0] 表示最后一个字符是'0' 所需的最少反转次数
        // dp[i][1] 表示最后一个字符是'1' 所需的最少反转次数
        int[][] dp = new int[len][2];

        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '1' ? 0 : 1;

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '0') {

                // 不需要翻转, 利用前一位的状态即可
                dp[i][0] = dp[i - 1][0];
                // 需要将翻转次数 + 1, 但是来源有两种: 0000 0或者0011 0
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;

            } else {  // s.charAt(i) == '1'

                // 需要翻转, 利用前一位前一位状态 + 1
                dp[i][0] = dp[i - 1][0] + 1;
                // 不需要翻转, 但是来源有两种: 0000 1或者0011 1
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);

            }
        }
        return Math.min(dp[len - 1][0], dp[len - 1][1]);
    }
}
