package top.colorfo.dpsubsequence;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; //dp[i] 表示i之前包括i的最长上升子序列
        int result = 0;
        Arrays.fill(dp, 1); //dp[i] 的初始值为1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = dp[i] > result ? dp[i] : result;  //不一定dp[n - 1]就是最长的子序列，
                                                       // 所以要在遍历的过程中，保存最大值。
        }
        return result;
    }
}
