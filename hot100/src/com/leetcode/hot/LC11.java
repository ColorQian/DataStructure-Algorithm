package com.leetcode.hot;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 * 11. 盛最多水的容器
 */
public class LC11 {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int curArea = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, curArea);

            // 移动较低的一边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
