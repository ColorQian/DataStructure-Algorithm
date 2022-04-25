package com.jianzhi.master;

public class Question19 {
    public boolean validPalindrome(String s) {
        return isValidL(s) || isValidR(s);
    }

    private boolean isValidR(String s) {
        if (s.length() == 1) return true;

        int count = 1;
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            char charL = s.charAt(l);
            char charR = s.charAt(r);

            if (charL != charR) {
                if (count == 1) {
                    count--;
                    r--;            // 删除右边的那个字符
                    continue;
                } else {
                    return false;
                }
            }

            l++;
            r--;
        }
        return true;
    }

    private boolean isValidL(String s) {
        if (s.length() == 1) return true;

        int count = 1;
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            char charL = s.charAt(l);
            char charR = s.charAt(r);

            if (charL != charR) {
                if (count == 1) {
                    count--;
                    l++;              // 删除左边的那个字符
                    continue;
                } else {
                    return false;
                }
            }

            l++;
            r--;
        }
        return true;
    }
}
