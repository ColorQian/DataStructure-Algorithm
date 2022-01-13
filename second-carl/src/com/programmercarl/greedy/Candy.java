package com.programmercarl.greedy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/candy/
 * 分发糖果
 */
public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        Arrays.fill(candy, 1);

        //先考虑 右边的评分 > 左边，从前向后遍历
        for (int i = 0; i < len - 1; i++) {
            if (ratings[i + 1] > ratings[i]) candy[i + 1] = candy[i] + 1;
        }

        //再考虑 左边的评分 > 右边，从后向前遍历(想清楚为什么要从后向前遍历)
        /**
         * 因为如果从前向后遍历，根据 ratings[i + 1] 来确定 ratings[i] 对应的糖果，
         * 那么每次都不能利用上前一次的比较结果了。
         * 所以确定左孩子大于右孩子的情况一定要从后向前遍历！
         */
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
        }

        int candySum = 0;
        for (int c : candy) {
            candySum += c;
        }
        return candySum;
    }
}
