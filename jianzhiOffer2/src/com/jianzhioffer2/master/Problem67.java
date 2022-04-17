package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * 剑指 Offer 67. 把字符串转换成整数
 */
public class Problem67 {
    public int strToInt(String str) {
        // 去除前后空格, 并转为char[] 数组
        char[] c = str.trim().toCharArray();
        if (c.length == 0) return 0;

        // 默认从第一位开始遍历
        int i = 1;
        // 符号位默认为正
        int sign = 1;

        // 判断正负号
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            i = 0;
        }

        // 开始处理,字符串 -> 数字
        int res = 0;
        int boundary = Integer.MAX_VALUE / 10;
        for (int j = i; j < c.length; j++) {
            // 如果不是数字, 跳出循环
            if (c[j] < '0' || c[j] > '9') break;

            // 判断是否越界 (这一步不太容易考虑!!!)
            if (res > boundary || (res == boundary && c[j] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // 真正的转换逻辑
            res = res * 10 + c[j] - '0';
        }
        return sign * res;
    }
}
