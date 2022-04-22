package com.jianzhi.master;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/QTMn0o/
 * 剑指 Offer II 010. 和为 k 的子数组
 *
 * 参考题解:labuladong
 * https://labuladong.github.io/algo/2/18/21/
 */
public class Question10 {
    /**
     * 方法一：HashMap + 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 前缀和出现的次数
        HashMap<Integer, Integer> preSum = new HashMap<>();
        // 初始化
        preSum.put(0, 1);

        int sum = 0;
        int sumDiff = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            // 统计前缀和
            sum += nums[i];

            // 目标前缀和
            sumDiff = sum - k;
            if (preSum.containsKey(sumDiff)) {
                // 目标前缀和出现的次数
                res += preSum.get(sumDiff);
            }

            // 记录前缀和
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    /**
     * 方法二：暴力求解 + 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int n = nums.length;
        // 构造前缀和
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 0; i < n; i++)
            preSum[i + 1] = preSum[i] + nums[i];

        int res = 0;
        // 穷举所有子数组
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                // 子数组 nums[j..i-1] 的元素和
                if (preSum[i] - preSum[j] == k)
                    res++;

        return res;
    }

}
