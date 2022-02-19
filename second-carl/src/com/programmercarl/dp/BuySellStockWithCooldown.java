package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 买卖股票的最佳时机(包含冷冻期)
 */
public class BuySellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        /**
         * dp[i][j]，第i天状态为j，所剩的最多现金为dp[i][j]。
         *
         * j的状态为：
         * 0：持有股票后的最多现金
         * 1：不持有股票（能购买）的最多现金
         * 2：不持有股票（冷冻期）的最多现金
         */
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
