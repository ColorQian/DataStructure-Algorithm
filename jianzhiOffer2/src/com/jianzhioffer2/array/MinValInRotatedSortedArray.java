package com.jianzhioffer2.array;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 旋转数组的最小数字
 */
public class MinValInRotatedSortedArray {
    public int minArray(int[] numbers) {
        int result = Integer.MAX_VALUE;

        for (int i = numbers.length - 1; i >= 1; i--) {  //从后往前遍历，遇到最小值就返回
            if (numbers[i] < numbers[i - 1]) {
                result = numbers[i];
                break;
            }
        }
        if (result == Integer.MAX_VALUE) return numbers[0];  //如果是没有旋转的升序数组，则直接返回nums[0]
        return result;
    }
}
