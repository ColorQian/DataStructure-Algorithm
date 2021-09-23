package top.colorfo.dp;

import java.util.Arrays;

/**
 * 有N件物品和一个最多能背重量为W的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
 * 每件物品都有无限个（也就是可以放入背包多次），求解将哪些物品装入背包里物品价值总和最大。
 * (完全背包和01背包问题唯一不同的地方就是，每种物品有无限件。)
 */
public class CompletePack {
    public static int testCompletePack(int[] weight, int[] value, int bagWeight) {
        int n = weight.length;
        int[] dp = new int[bagWeight + 1];

        for (int i = 0; i < n; i++) {
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[bagWeight];
    }

    //-------------------
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        testCompletePack(weight,value,4);
    }
}
