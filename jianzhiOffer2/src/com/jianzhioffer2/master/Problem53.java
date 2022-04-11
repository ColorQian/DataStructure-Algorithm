package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class Problem53 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;

        int result = 0;
        if (target < nums[0]) return result;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == target) {
                result++;
                if (nums[i + 1] > nums[i]) {  // 如果数组中下一个比当前target要大，终止循环
                    break;
                }
            }
        }
        if (nums[len - 1] == target) result++; // 判断最后一个元素是不是目标值

        return result;
    }
}
