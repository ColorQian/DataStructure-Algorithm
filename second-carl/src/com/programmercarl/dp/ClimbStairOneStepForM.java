package com.programmercarl.dp;

/**
 * 一步一个台阶，两个台阶，三个台阶，.......，直到 m个台阶。问有多少种不同的方法可以爬到楼顶呢？
 *
 * 1阶，2阶，.... m阶就是物品，楼顶就是背包。
 *
 * 每一阶可以重复使用，例如跳了1阶，还可以继续跳1阶。
 *
 * 问跳到楼顶有几种方法其实就是问装满背包有几种方法。
 *
 * 此时大家应该发现这就是一个完全背包问题了！(对应完全背包的排列问题)
 */
public class ClimbStairOneStepForM {
    /**
     *
     * @param n 表示楼顶
     * @param m 表示一步最多可以跳m步
     * @return 跳上楼顶n,共有多少种方法
     */
    public int climbStairs(int n, int m) {
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int j = 1; j <= n; j++) {  //先遍历背包容量
            for (int i = 1; i <= m; i++) {  //再遍历物品
                if (j >= i) {
                    dp[j] = dp[j] + dp[j - i];
                }
            }
        }
        return dp[n];
    }
}
