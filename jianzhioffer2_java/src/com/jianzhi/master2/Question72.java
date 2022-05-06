package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/jJ0w9p/
 * 剑指 Offer II 072. 求平方根
 */
public class Question72 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid <= x) {

                ans = mid;      // 记录结果
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
