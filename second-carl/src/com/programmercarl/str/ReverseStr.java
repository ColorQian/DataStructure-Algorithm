package com.programmercarl.str;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class ReverseStr {
    public void reverseString(char[] s) {
        int len = s.length;
        int left = 0;
        int right = len - 1;

        while (right > left) {
            char c = ' ';
            c = s[left];
            s[left] = s[right];
            s[right] = c;
            right--;
            left++;
        }

    }
}
