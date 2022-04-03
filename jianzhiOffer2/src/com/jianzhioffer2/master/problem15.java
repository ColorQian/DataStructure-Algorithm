package com.jianzhioffer2.master;

/**
 * 统计二进制中 '1' 的个数
 */
public class problem15 {
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') res++;
        }
        return res;
    }
}
