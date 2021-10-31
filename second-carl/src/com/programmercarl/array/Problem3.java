package com.programmercarl.array;

/**
 * 将数组中指定的元素全部移动到末尾
 */
public class Problem3 {
    //双指针算法
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp; //交换完成之后j后移一位
            }
        }
        return j;
    }
}
