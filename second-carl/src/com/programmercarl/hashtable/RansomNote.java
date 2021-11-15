package com.programmercarl.hashtable;

/**
 * https://leetcode-cn.com/problems/ransom-note/
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] chars = new int[26];  //用来存放magazine中字符出现的次数
        for (char c : magazine.toCharArray()) {
            chars[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            chars[c - 'a']--;      //ransomNote中出现，则把统计的字符个数减去1
            if (chars[c - 'a'] < 0) return false;  //如果个数为负，则直接返回false
        }
        return true;
    }
}
