package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/2VG8Kg/
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 */
public class Question8 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (right < len) {
            // 把窗口内的元素加起来
            sum += nums[right];

            // 这里使用while循环, 是为了在收缩左边窗口时, 找到符合的最小窗口
            while (sum >= target) {  // while 中的判断条件这样写也可: left <= right && sum >= target
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }

            // 窗口右指针 右移
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
