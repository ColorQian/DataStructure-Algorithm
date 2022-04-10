package com.jianzhioffer2.master;

import java.util.HashMap;

public class Problem50 {
    public char firstUniqChar(String s) {
        if (s.length() == 0 || "".equals(s)) return ' ';

        // 将字符串中出现的字符做个计数
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 再次遍历s.toCharArray(),如果map中的计数为1,则找到第一个出现次数为1的字符
        char res = ' ';
        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                res = c;
                break;
            }
        }

        return res;
    }
}
