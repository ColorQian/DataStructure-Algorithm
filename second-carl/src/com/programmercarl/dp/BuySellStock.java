package com.programmercarl.dp;

public class BuySellStock {
    /**
     * 方法一：贪心算法(一次遍历，记录最左的最小值价格，以及获取当前区间的最大利润)
     */
    public int maxProfit1(int[] prices) {
        int lowPrice = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            lowPrice = Math.min(lowPrice, prices[i]);  //取最左的最小值价格
            result = Math.max(result, prices[i] - lowPrice); //取当前区间的最大利润
        }
        return result;
    }

    /**
     * 方法二：动态规划
     */
    public int maxProfit2(int[] prices) {
        //dp[i][0] 表示第 i 天不持有股票，手头的现金, dp[i][1] 表示持有股票，手头的现金
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
