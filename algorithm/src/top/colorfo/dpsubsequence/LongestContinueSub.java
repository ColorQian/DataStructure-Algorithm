package top.colorfo.dpsubsequence;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 */
public class LongestContinueSub {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int[] dp = new int[n];  //dp[i]：以下标i为结尾的数组的连续递增的子序列长度为dp[i]。
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
            result = result > dp[i] ? result : dp[i];
        }
        return result;
    }
}
