package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/ZVAVXX/
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 */
public class Question9 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 0) return 0;
        int left = 0;
        int right = 0;
        int multi = 1;
        int count = 0;

        while (right < nums.length) {
            multi *= nums[right];

            while (left <= right && multi >= k) {
                multi /= nums[left];
                left++;
            }

            // 统计结果
            count += right >= left ? right - left + 1 : 0;
            right++;
        }
        return count;
    }
}
