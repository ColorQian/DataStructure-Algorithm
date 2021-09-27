package top.colorfo.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class SellStock4 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int j = 1; j < 2 * k; j += 2) {
            dp[0][j] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k - 1; j+= 20) {
                dp[i][j + 1] = Math.max(dp[i - 1][j] - prices[i], dp[i - 1][j + 1]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 1] + prices[i], dp[i - 1][j + 2]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}
