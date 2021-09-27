package top.colorfo.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class SellStock2 {

    //贪心算法
    public int maxProfit2(int[] prices) {
        if (prices.length == 1) return 0;

        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) result += temp;
        }
        return result;
    }

    //动态规划
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        // dp[i][0] 表示第i天持有股票，所剩余的最大金额
        // dp[i][1] 表示第i天不持有股票，所剩余的最大金额
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }
}
