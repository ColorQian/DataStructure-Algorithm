package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 * 剑指 Offer 60. n个骰子的点数
 *
 * 参考题解：
 * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/nge-tou-zi-de-dian-shu-dong-tai-gui-hua-ji-qi-yo-3/
 */
public class Problem60 {
    public double[] dicesProbability(int n) {
        //1. dp[i][j] 表示投掷完 i 枚骰子后，点数 j 出现的 次数
        // 点数范围为[n, 6n]
        int[][] dp = new int[n + 1][6 * n + 1];

        //2. dp数组初始化
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        //3.遍历顺序
        for (int i = 2; i <= n; i++) { //表示当前第几枚骰子
            for (int j = i; j <= 6 * i; j++) { // 表示当前点数j
                for (int k = 1; k <= 6 && k < j; k++) {
                    // 4.状态转移方程
                    // 例如: dp[2][3] = dp[1][3 - 1] + dp[1][3 - 2]
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double all = Math.pow(6, n);
        // 因为骰子的范围[n, 6n], 所以数组大小6n - n + 1
        double[] res = new double[6 * n - n + 1];
        for (int i = n; i <= 6 * n; i++) {
            res[i - n] = dp[n][i] / all;
        }
        return res;
    }
}
