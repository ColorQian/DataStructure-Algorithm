package top.colorfo.dp;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class EqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false; //如果是奇数，则不能平分为两个相等的子集

        int target = sum / 2;
        int[] dp = new int[target + 1]; //dp[j] 表示 容量为j 可放入的最大元素和
        dp[0] = 0;                     //初始化dp

        //确定遍历顺序以及，递归表达式
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }

}
