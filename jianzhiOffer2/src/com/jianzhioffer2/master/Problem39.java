package com.jianzhioffer2.master;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/submissions/
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 */
public class Problem39 {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        int target = nums.length / 2 + 1;
        int len = nums.length;
        int res = -1;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) >= target) {
                res = nums[i];
                break;
            }
        }
        return res;
    }
}
