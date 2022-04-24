package com.jianzhi.master;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/VabMRr/
 * 剑指 Offer II 015. 字符串中的所有变位词
 */
public class Question15 {
    /**
     *
     * 滑动窗口(双指针实现窗口) + 哈希表
     *
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] count = new int[26];

        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
        }

        if (allZero(count)) res.add(0);

        for (int r = p.length(); r < s.length(); r++) {
            // 滑动窗口的右指针
            count[s.charAt(r) - 'a']--;

            // 滑动窗口的左指针
            int l = r - p.length();
            count[s.charAt(l) - 'a']++;

            if (allZero(count)) res.add(l + 1);
        }
        return res;

    }

    private boolean allZero(int[] count) {
        for (int n : count) {
            if (n != 0) return false;
        }
        return true;
    }
}
