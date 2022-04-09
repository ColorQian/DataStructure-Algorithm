package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 剑指 Offer 42. 连续子数组的最大和
 */
public class Problem42 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (sum > res) res = sum;

            if (sum < 0) sum = 0;
        }
        return res;
    }
}
