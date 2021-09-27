package top.colorfo.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class SellStock2 {

    //贪心算法
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) result += temp;
        }
        return result;
    }
}
