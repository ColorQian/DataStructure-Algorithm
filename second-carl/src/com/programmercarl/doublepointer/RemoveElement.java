package com.programmercarl.doublepointer;

/**
 * https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) return 0;

        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return j;
    }
}
