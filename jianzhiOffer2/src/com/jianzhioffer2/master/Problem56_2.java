package com.jianzhioffer2.master;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/submissions/
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 */
public class Problem56_2 {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int res = -1;
        for (int i = 0; i < len; i++) {
            if (map.get(nums[i]) == 1) {
                res = nums[i];
                break;
            }
        }
        return res;
    }
}
