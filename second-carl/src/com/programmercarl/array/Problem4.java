package com.programmercarl.array;

/**
 * 利用双指针 实现有序数组的平方
 */
public class Problem4 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        int i = 0;
        int j = nums.length - 1;

        while (k >= 0) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[k--] = nums[i] * nums[i];
                i++;
            } else {
                result[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }
}
