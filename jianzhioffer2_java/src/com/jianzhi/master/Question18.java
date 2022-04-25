package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/XltzEq/
 * 剑指 Offer II 018. 有效的回文
 */
public class Question18 {
    public boolean isPalindrome(String s) {
        //String str = s.trim();
        int l = 0;
        int r = s.length() - 1;
        boolean flag = true;

        while (l < r) {
            char charL = s.charAt(l);
            char charR = s.charAt(r);

            if (!Character.isLetterOrDigit(charL)) {   // 判断一个字符是不是字母或数字
                l++;
            } else if (!Character.isLetterOrDigit(charR)) {
                r--;
            } else {
                charL = Character.toLowerCase(charL);  // 将大写字母转换为小写字母
                charR = Character.toLowerCase(charR);

                if (charL != charR) {
                    flag = false;
                    break;
                }

                l++;
                r--;
            }
        }
        return flag;
    }
}
