package com.programmercarl.greedy;

/**
 * https://leetcode-cn.com/problems/wiggle-subsequence/
 * 摆动序列长度
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int preDiff = 0;
        int curDiff = 0;
        int result = 1;  //记录峰值，峰值个数即为摆动序列长度
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];

            //出现峰值
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }
}
