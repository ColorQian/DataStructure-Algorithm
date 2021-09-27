package top.colorfo.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class SellStock {

    //贪心算法
    public int maxProfit2(int[] prices) {
        int low = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            result = Math.max(result, prices[i] - low);
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
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[prices.length - 1][1];
    }
}
