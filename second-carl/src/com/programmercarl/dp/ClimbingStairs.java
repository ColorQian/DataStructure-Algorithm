package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1) return n;

        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 3; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
