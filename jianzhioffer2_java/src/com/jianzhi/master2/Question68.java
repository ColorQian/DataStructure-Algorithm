package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/N6YdxV/
 * 剑指 Offer II 068. 查找插入位置
 */
public class Question68 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nums.length;
    }
}
