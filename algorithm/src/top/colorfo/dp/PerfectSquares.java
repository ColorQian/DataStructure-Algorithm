package top.colorfo.dp;

import java.util.Arrays;

public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1]; //组成i,所需的完全平方数的最小个数dp[i]

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {  //遍历物品
            for (int j = i * i; j <= n; j++) {   //遍历背包
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
