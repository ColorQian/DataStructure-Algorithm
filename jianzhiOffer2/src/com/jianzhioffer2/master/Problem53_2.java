package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/submissions/
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class Problem53_2 {
    public int missingNumber(int[] nums) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                result = i;
                break;
            }
        }
        if (result == -1) result = nums.length;
        return result;
    }
}
