package com.programmercarl.greedy;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 求一个数组的最大子数组和
 */
public class MaxSubarray {
    /**
     *贪心的思路为局部最优：当前“连续和”为负数的时候立刻放弃，
     * 从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
     * 从而推出全局最优：选取最大“连续和”
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int result = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            result = sum > result ? sum : result;  //result保存最大子数组和
            if (sum < 0) {     //如果sum < 0,则将sum置为0,重新开始计数。
                sum = 0;
            }
        }
        return result;
    }
}
