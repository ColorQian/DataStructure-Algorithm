package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 剑指 Offer 17. 打印从1到最大的n位数
 */
public class Problem17 {
    public int[] printNumbers(int n) {
        double size = Math.pow(10, n) - 1;
        int[] res = new int[(int)size];
        for (int i = 0; i < size; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
