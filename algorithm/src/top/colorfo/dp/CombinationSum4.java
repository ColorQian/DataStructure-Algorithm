package top.colorfo.dp;

/**
 * https://leetcode-cn.com/problems/combination-sum-iv/
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;

        int[] dp = new int[target + 1];  //dp[i] 表示 容量为i的背包 一共有多少种排列
                                         //即-dp[i]: 凑成目标正整数为i的排列个数为dp[i]
        dp[0] = 1;
        for (int j = 1; j <= target; j++) { //先遍历背包，再遍历物品，求排列
            for (int i = 0; i < n; i++) {
                //背包比物品大，才可放入
                if (j >= nums[i]) dp[j] += dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}
