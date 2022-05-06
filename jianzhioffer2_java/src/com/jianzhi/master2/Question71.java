package com.jianzhi.master2;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/cuyjEf/
 * 剑指 Offer II 071. 按权重生成随机数
 */
public class Question71 {
    int[] sums;
    int total;

    public Question71(int[] w) {
        sums = new int[w.length];
        total = 0;
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sums[i] = total;
        }
    }

    public int pickIndex() {
        Random r = new Random();
        int p = r.nextInt(total);

        int left = 0;
        int right = sums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sums[mid] > p) {
                if (mid == 0 || sums[mid - 1] <= p) {
                    return mid;
                }

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
