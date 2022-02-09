package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/integer-break/
 * 整数拆分
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;

        int result = 1;
        while (n > 4) {
            result = result * 3;
            n -= 3;
        }
        result = result * n;
        return result;
    }
}
