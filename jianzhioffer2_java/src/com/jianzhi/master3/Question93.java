package com.jianzhi.master3;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/Q91FMA/
 * 剑指 Offer II 093. 最长斐波那契数列
 */
public class Question93 {
    public int lenLongestFibSubseq(int[] A) {
        int len = A.length;
        // dp[i][j] 表示以A[j]为最后一个数字, A[i]为倒数第2个数字的斐波那契数列的长度
        // 如果存在A[k] = A[j] - A[i] 且k < i 则 dp[i][j] = dp[k][i] + 1
        int[][] dp = new int[len][len];

        // 建立A[k] -> k的映射, 这样可以快速通过A[k]拿到下标k
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(A[i], i);
        }

        int maxLen = 0;
        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int tempLen = A[j] - A[i]; // A[k];
                if (map.containsKey(tempLen) && map.get(tempLen) < i) {
                    int k = map.get(tempLen);
                    dp[i][j] = dp[k][i] + 1;
                    maxLen = Math.max(dp[i][j] + 2, maxLen);
                }
            }
        }
        return maxLen;
    }
}
