package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/dKk3P7/
 * 剑指 Offer II 032. 有效的变位词
 */
public class Question32 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return false;

        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            hash[c - 'a']--;
            if (hash[c - 'a'] < 0) return false;
        }

        return true;
    }
}
