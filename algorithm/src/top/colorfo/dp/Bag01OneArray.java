package top.colorfo.dp;

import java.util.Arrays;

/**
 * 01背包问题，使用一维数组实现
 */
public class Bag01OneArray {

    public static int test01BagProblem(int[] weight, int[] value, int bagSize) {

        //定义dp数组，dp[j] 表示容量为j的背包 所放物品的总价值
        int[] dp = new int[bagSize + 1];

        dp[0] = 0; //初始化dp数组

        //确定遍历顺序，以及递归的表达式
        for (int i = 0; i < weight.length; i++) {  //遍历物品
            for (int j = bagSize; j >= weight[i] ; j--) {  //遍历背包容量(倒序遍历)
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[weight.length];
    }

    //---------------
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};

        test01BagProblem(weight,value,4);


    }
}
