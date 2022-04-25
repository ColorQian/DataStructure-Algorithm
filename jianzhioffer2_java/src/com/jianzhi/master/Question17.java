package com.jianzhi.master;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/M1oyTv/
 * 剑指 Offer II 017. 含有所有字符的最短字符串
 */
public class Question17 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 表示有多少个不同的字符
        // 注意下面对于count的处理
        int count = map.size();

        int start = 0, end = 0;
        int minStart = 0, minEnd = 0;
        int minLen = Integer.MAX_VALUE;

        // 注意这里条件的判断 (count == 0 && end == s.length())
        while (end < s.length() || (count == 0 && end == s.length())) {
            if (count > 0) {
                char r = s.charAt(end);
                if (map.containsKey(r)) {
                    map.put(r, map.get(r) - 1);

                    if (map.get(r) == 0) count--;
                }
                end++;  // 右指针右移
            } else {  // count <= 0
                if (end - start < minLen) {
                    minStart = start;
                    minEnd = end;
                    minLen = end - start;
                }

                char l = s.charAt(start);
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);

                    if (map.get(l) == 1) count++;
                }
                start++;  // 左指针右移
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd);

    }
}
