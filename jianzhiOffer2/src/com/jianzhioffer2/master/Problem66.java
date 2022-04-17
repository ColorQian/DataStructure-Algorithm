package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * 剑指 Offer 66. 构建乘积数组
 *
 * 此题跟 "分发糖果有点像"
 */
public class Problem66 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) return new int[0];

        // 1.
        // 记录当前元素左边所有元素的乘积
        int[] left = new int[len];
        // 记录当前元素右边所有元素的乘积
        int[] right = new int[len];

        // 2.数组初始化
        left[0] = 1;
        right[len - 1] = 1;

        // 3.遍历顺序,left从前往后, right从后往前
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        // 4.确定递推公式
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
