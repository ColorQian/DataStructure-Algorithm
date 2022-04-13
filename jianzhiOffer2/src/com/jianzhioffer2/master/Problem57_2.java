package com.jianzhioffer2.master;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/submissions/
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 */
public class Problem57_2 {
    // 此题利用滑动窗口是个好的选择
    public int[][] findContinuousSequence(int target) {
        // 滑动窗口是一个左闭右开区间
        int i = 1;
        int j = 1;
        int sum = 0;
        List<int[]> result = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {  // 扩大窗口，也就是指针 j 右移
                sum += j;
                j++;
            } else if (sum > target) { // 缩小窗口，指针 i 右移
                sum -= i;
                i++;
            } else {          // 收集结果，结果收集完，左边的起始位置 i 右移一位
                int[] targetArr = new int[j - i];
                for (int k = i; k < j; k++) {
                    targetArr[k - i] = k;
                }
                result.add(targetArr);

                sum -= i;   // 千万不要忘记这一步！！！
                i++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
