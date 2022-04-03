package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * 剑指 Offer 16. 数值的整数次方
 */
public class Problem16 {
    // 使用递归的方式
    public double myPow(double x, int n) {
        // 递归终止条件
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;

        double half = myPow(x, n / 2);

        return half * half * myPow(x, n % 2);
    }
}
