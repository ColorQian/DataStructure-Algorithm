package com.jianzhioffer2.master;

public class Problem58_2 {
    // 方法一：利用 下标和n 对 字符串长度取余, 然后拼接字符串
    public String reverseLeftWords1(String s, int n) {
        if (s.length() == 0) return null;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt((i + n) % s.length());
            sb.append(c);
        }
        return sb.toString();
    }

    // 方法二
    public String reverseLeftWords2(String s, int n) {
        String s1 = s.substring(0, n);
        String s2 = s.substring(n, s.length());
        return s2 + s1;
    }
}
