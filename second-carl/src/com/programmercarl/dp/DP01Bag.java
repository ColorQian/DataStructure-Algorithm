package com.programmercarl.dp;


public class DP01Bag {
    /**
     * 使用一维数组解决0-1背包问题
     * @param weight
     * @param value
     * @param bagWeight
     */
    public static void test01BagProblem(int[] weight, int[] value, int bagWeight) {
        int len = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];

        //先遍历物品，再遍历背包，遍历背包时，要倒序遍历(从大到小)
        for (int i = 0; i < len; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        for (int v : dp) {
            System.out.print(v + " ");
        }
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;

        test01BagProblem(weight, value, bagWight);
    }
}
