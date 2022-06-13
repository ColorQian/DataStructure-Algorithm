package com.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/
 * 15. 三数之和
 */
public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len <= 2) return result;

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // 对 i 去重

            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;  // 对 left 去重
                    while (left < right && nums[right] == nums[right - 1]) right--;  // 对right 去重

                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
