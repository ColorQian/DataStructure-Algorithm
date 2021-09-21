package top.colorfo.dp;

/**
 * 0-1背包问题
 * 使用二维数组实现
 */
public class Bag01 {

    public int getMaxValue(int[] weight, int[] value, int bagSize) {
        int number = weight.length;

        //dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
        int[][] dp = new int[number][bagSize + 1];

        //当背包容量j >= weight[0] 时，才往里面放[物品0]
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        for (int i = 1; i < number; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j]; //说明物品i放不进去容量为j的背包中
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        //打印dp数组
        for (int i = 0; i < number; i++){
            for (int j = 0; j <= bagSize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }

        return dp[number - 1][bagSize];
    }

    //-------------
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};

        Bag01 bag = new Bag01();
        int maxValue = bag.getMaxValue(weight, value, 4);
        System.out.println("----------------");
        System.out.println(maxValue);
    }
}
