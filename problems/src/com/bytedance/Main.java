package com.bytedance;

import java.util.HashMap;

public class Main {
    public String lengthOfLongestSubstring(String s) {


        int left = 0;
        int maxLen = 1;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 更新left的位置
                // abca abba
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            if (i - left + 1 > maxLen) {
                start = left;            // 这里一定记得使用start 保存 要截取子串的起始位置，不能使用left!!!
                maxLen = i - left + 1;

            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.lengthOfLongestSubstring("qqwertynywe"));
    }
}
