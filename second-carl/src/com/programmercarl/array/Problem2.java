package com.programmercarl.array;

/**
 * 有序数组的二分查找
 */
public class Problem2 {
    public int search(int[] nums, int target) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                //往右边查找
                left = mid + 1;
            } else if (nums[mid] > target) {
                //往左边查找
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return result;
    }
}
