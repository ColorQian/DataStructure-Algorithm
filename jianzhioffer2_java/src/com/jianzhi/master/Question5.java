package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/aseY1I/
 * 剑指 Offer II 005. 单词长度的最大乘积
 */
public class Question5 {
    public int maxProduct(String[] words) {
        // 1. 初始化每个字符串对应的哈希表
        boolean[][] hash = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                hash[i][c - 'a'] = true;
            }
        }

        // 2. 计算不相同字符串的最大值
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    if (hash[i][k] && hash[j][k]) break;
                }

                if (k == 26) {
                    int multi = words[i].length() * words[j].length();
                    res = Math.max(res, multi);
                }
            }
        }
        return res;
    }
}
