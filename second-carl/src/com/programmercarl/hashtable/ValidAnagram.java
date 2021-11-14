package com.programmercarl.hashtable;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) { //记录不同的字母出现的次数
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) { //利用已经记录的数据判断，是否是字母异位词
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
