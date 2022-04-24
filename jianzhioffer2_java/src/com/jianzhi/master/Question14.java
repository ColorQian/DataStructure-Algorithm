package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/MPnaiL/
 * 剑指 Offer II 014. 字符串中的变位词
 */
public class Question14 {

    // 滑动窗口(双指针) + 哈希表
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        if (allZero(count)) return true;

        for (int right = s1.length(); right < s2.length(); right++) {
            // 窗口右移
            count[s2.charAt(right) - 'a']--;

            // 窗口左移
            int left = right - s1.length();
            count[s2.charAt(left) - 'a']++;

            if (allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int n : count) {
            if (n != 0) return false;
        }
        return true;
    }
}
