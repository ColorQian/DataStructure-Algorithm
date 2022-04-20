package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/JFETK5/
 * 剑指 Offer II 002. 二进制加法
 */
public class Question2 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int n1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? b.charAt(j) - '0' : 0;
            i--;
            j--;

            int temp = n1 + n2 + carry;
            sb.append(temp % 2);
            carry = temp / 2;
        }
        return sb.reverse().toString();
    }
}
