package com.leetcode.hot;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 3. 无重复字符的最长子串
 */
public class LC03 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) return len;

        int result = Integer.MIN_VALUE;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
