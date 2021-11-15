package com.programmercarl.str;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class ImplementStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        char[] ss = haystack.toCharArray();
        char[] pp = needle.toCharArray();
        int m = ss.length;
        int n = pp.length;

        //从原字符串的【出发点】开始匹配
        for (int i = 0; i <= m - n; i++) {
            int a = i;
            int b = 0;  //从匹配串的[起始位置]开始

            while (b < n && ss[a] == pp[b]) {
                a++;
                b++;
            }

            if (b == n) return i;
        }

        return -1;
    }
}
