package top.colorfo.dp;

import java.util.Arrays;

public class Test {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] -= prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[len - 1][1];
    }

    //------------
    public static void main(String[] args) {
        maxProfit(new int[]{7,1,5,3,6,4});
    }
}
