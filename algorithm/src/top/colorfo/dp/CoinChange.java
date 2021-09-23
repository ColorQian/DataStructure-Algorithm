package top.colorfo.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change-2/
 */
public class CoinChange {

    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[] dp = new int[amount + 1];  //dp[i] 表示 装满容量为i的背包有多少种方法
        dp[0] = 1;
        for (int i = 0; i < n; i++) {  //遍历物品(也就是硬币)
            for (int j = coins[i]; j <= amount; j++) {  //遍历背包
                dp[j] += dp[j - coins[i]];
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[amount];
    }

    //--------------
    public static void main(String[] args) {
        CoinChange change = new CoinChange();
        int change1 = change.change(5, new int[]{1, 2, 5});

        System.out.println(change1);
    }
}
