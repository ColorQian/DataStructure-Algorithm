package com.jianzhi.master;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/A1NYOS/
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 */
public class Question11 {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        // key: 前缀和, value: 累加到当前前缀和的数字下标
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, -1);

        int maxLen = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (nums[i] == 0 ? -1 : 1);

            if (preSum.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - preSum.get(sum));
            } else {
                preSum.put(sum, i);
            }
        }
        return maxLen;
    }
}
