package com.programmercarl.greedy;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 买卖股票的最佳时机2
 */
public class BuyStock2 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int temp = prices[i + 1] - prices[i];
            if (temp > 0) result += temp;
        }
        return result;
    }
}
