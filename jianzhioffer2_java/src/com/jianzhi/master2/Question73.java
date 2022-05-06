package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/nZZqjQ/
 * 剑指 Offer II 073. 狒狒吃香蕉
 */
public class Question73 {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }

        int left = 1;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;  // 表示吃香蕉的速度
            int hours = getHours(piles, mid); // 按mid的速度吃香蕉, 需要的时间(小时)

            if (hours <= h) {
                if (mid == 1 || getHours(piles, mid - 1) > h) {
                    return mid;
                }

                // 尝试用更小的速度吃
                right = mid - 1;

            } else { // hours > h , 应该用更快的速度吃
                left = mid + 1;
            }
        }
        return -1;
    }

    public int getHours(int[] piles, int speed) {
        int result = 0;
        for (int pile : piles) {
            if (pile <= speed) {
                result += 1;
            } else {
                if (pile % speed == 0) {
                    result += pile / speed;
                } else {
                    result += pile / speed + 1;
                }
            }
        }
        return result;
    }
}
