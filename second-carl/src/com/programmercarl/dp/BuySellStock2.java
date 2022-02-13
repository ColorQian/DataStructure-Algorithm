package com.programmercarl.dp;

public class BuySellStock2 {
    /**
     * 方法一：贪心解法
     */
    public int maxProfit1(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) result += temp;
        }
        return result;
    }

    /**
     * 方法二：动态规划
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);  //体现了股票可以买卖多次
        }
        return dp[prices.length - 1][0];
    }
}
