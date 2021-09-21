package top.colorfo.dp;

public class LastStone {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum >> 1; //sum / 2

        int[] dp = new int[target + 1]; //dp[j] 表示容量j 可以 装入的最大重量 dp[j]
        dp[0] = 0;   //初始化

        //确定遍历顺序以及状态转移方程
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - dp[target] - dp[target];
    }
}
