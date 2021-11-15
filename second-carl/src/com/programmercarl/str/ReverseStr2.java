package com.programmercarl.str;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class ReverseStr2 {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();

        for (int i = 0; i < str.length; i += 2 * k) {
            if (i + k - 1 <= str.length - 1) { //剩余字符串大于等于k,小于2k
                reverse(str, i, i + k - 1);
                continue;
            }

            //如果少于k个，全部反转
            reverse(str, i, str.length - 1);
        }

        return String.valueOf(str);
    }

    public void reverse(char[] str, int left, int right) {
        while (right > left) {
            char c = str[left];
            str[left] = str[right];
            str[right] = c;
            right--;
            left++;
        }
    }
}
