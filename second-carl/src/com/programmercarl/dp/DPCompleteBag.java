package com.programmercarl.dp;

public class DPCompleteBag {
    //完全背包的方法测试
    public static void testCompleteBag(int bagSize, int[] weight, int[] value) {
        //1.dp[j] 表示容量为j 的背包，能够背的物品的最大价值为dp[j]
        int[] dp = new int[bagSize + 1];

        //2.默认初始化为0

        //3.先遍历物品，再遍历背包，遍历背包是从小到大
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagSize ; j++) {
                //4.确定状态转移方程
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        for (int result : dp) {
            System.out.print(result + " ");
        }
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        testCompleteBag(bagWeight, weight, value);
    }
}
