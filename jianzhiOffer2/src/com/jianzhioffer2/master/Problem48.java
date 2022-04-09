package com.jianzhioffer2.master;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/submissions/
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 */
public class Problem48 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 1;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);

            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
