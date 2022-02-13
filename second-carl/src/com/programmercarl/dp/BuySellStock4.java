package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class BuySellStock4 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;

        //dp[i][j] 表示第 i 天，买入或卖出股票所得的最大现金,第几次买入或卖出股票的状态用 j 表示
        //如果k = 2,相当于下标 j 最大为4, 0:不操作 1:第一次买 2:第一次卖 3:第二次买 4:第二次卖
        int[][] dp = new int[prices.length][2 * k + 1];

        //dp数组初始化
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= 2 * k; j++) {
                if (j % 2 == 1) {  //j为奇数,代表买入状态
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {           //j为偶数,代表卖出状态
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}
