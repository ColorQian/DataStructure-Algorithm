package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 分割等和子集
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int bagSize = sum / 2;

        //dp[j]表示 背包总容量是j，最大可以凑成j的子集总和为dp[j]。
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[bagSize] == bagSize;
    }
}
