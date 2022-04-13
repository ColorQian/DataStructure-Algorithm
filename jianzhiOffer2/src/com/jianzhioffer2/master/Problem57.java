package com.jianzhioffer2.master;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * 剑指 Offer 57. 和为s的两个数字
 */
public class Problem57 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        if (len == 1) return new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = nums[map.get(nums[i])];
                res[1] = nums[i];
                break;
            }
            map.put(target - nums[i], i);
            if (nums[i] >= target) break;
        }
        return res;
    }
}
