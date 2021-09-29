package top.colorfo.dpsubsequence;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        //dp[i] 表示i之前的最大子序列和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > result) result = dp[i];
        }
        return result;
    }
}
