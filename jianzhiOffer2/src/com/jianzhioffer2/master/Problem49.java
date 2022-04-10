package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/chou-shu-lcof/submissions/
 * 剑指 Offer 49. 丑数
 */
public class Problem49 {
    public int nthUglyNumber(int n) {
        // dp[i] 表示第i个丑数的值是dp[i]
        int[] dp = new int[n];

        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);

            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
