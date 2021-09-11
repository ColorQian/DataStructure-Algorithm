package top.colorfo.greedy;

/**
 * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 */
public class SellStock {
    public int maxProfit(int[] prices) {

        if (prices.length <= 0) return 0;

        int result = 0;

        //遍历数组求两天的价格差，只要是正(说明有利润)，就累加
        for (int i = 0; i < prices.length - 1; i++) {
            int temp = prices[i+1] - prices[i];
            if (temp > 0){
                result += temp;
            }
        }
        return result;
    }
}
