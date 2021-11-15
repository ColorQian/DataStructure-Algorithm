package com.programmercarl.str;

/**
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class LeftRotateStr {
    public String reverseLeftWords(String s, int n) {
        if (s.length() == 0) return null;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt((i + n) % s.length());
            sb.append(c);
        }
        return sb.toString();
    }
}
