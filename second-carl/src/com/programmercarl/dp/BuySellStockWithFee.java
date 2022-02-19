package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 买卖股票的最佳时机(含手续费)
 */
public class BuySellStockWithFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 1) return 0;

        // dp[i][0] 表示 第 i 天持有股票，手头的最大现金
        // dp[i][1] 表示 第 i 天不持有股票，手头的最大现金
        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    }
}
