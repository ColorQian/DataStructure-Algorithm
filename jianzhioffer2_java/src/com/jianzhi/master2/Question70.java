package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/skFtm2/
 * 剑指 Offer II 070. 排序数组中只出现一次的数字
 */
public class Question70 {
    public int singleNonDuplicate(int[] nums) {
        int resut = 0;
        for (int i = 0; i < nums.length; i++) {
            resut ^= nums[i];
        }
        return resut;
    }
}
