package top.colorfo.dp;

import java.util.Arrays;

public class CoinChange2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {  //如果dp[j - coins[i]]是初始值则跳过
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }

    //============
    public static void main(String[] args) {
        CoinChange2 coinChange2 = new CoinChange2();
        int i = coinChange2.coinChange(new int[]{1,2,5}, 5);
        System.out.println(i);
    }
}
