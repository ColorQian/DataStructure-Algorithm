package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * 剑指 Offer 46. 把数字翻译成字符串
 *
 * 和复原IP地址那个题非常相像
 */
public class Problem46 {
    String s;
    int res;
    public int translateNum(int num) {
        if (num == 0) return 1;

        s = String.valueOf(num);
        res = 0;
        traversal(0);
        return res;
    }

    private void traversal(int startIndex) {
        if (startIndex == s.length()) {
            res++;
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (isValid(sub)) {
                traversal(i + 1);
            }
        }
    }

    private boolean isValid(String sub) {
        if (sub.length() >= 3) return false;

        if (sub.length() > 1 && sub.charAt(0) == '0') return false;

        int num = Integer.valueOf(sub);
        if (num > 25) return false;

        return true;
    }
}
