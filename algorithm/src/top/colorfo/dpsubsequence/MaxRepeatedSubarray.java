package top.colorfo.dpsubsequence;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 */
public class MaxRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //dp[i][j] ：以下标i - 1为结尾的nums1，和以下标j - 1为结尾的nums2，最长重复子数组长度为dp[i][j]。
        int[][] dp = new int[n1 + 1][n2 + 1];

        int result = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                result = result > dp[i][j] ? result : dp[i][j];
            }
        }
        return result;
    }
}
