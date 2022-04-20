package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/w3tCBm/
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 */
public class Question3 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 整数 i 的二进制形式中 1 的个数比 i & (i - 1) 的二进制形式中1的个数多1
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
}
