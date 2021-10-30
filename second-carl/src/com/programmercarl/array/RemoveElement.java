package com.programmercarl.array;

/**
 * https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) return 0;

        int j = 0;    //j相当于指向移除的元素
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) { //遍历数组，如果是要移除的元素，i后移一位
                                  //如果不是，与j位置，之后i,j都后移一位
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        return j;
    }
}
