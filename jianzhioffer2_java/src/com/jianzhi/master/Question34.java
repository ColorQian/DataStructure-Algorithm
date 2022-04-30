package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/lwyVBB/
 * 剑指 Offer II 034. 外星语言是否排序
 */
public class Question34 {
    public boolean isAlienSorted(String[] words, String order) {
        // 外星语言的字典序
        int[] hash = new int[order.length()];
        for (int i = 0; i < hash.length; i++) {
            hash[order.charAt(i) - 'a'] = i;
        }

        // 根据外星字典序, 两个两个比较words中的字符串
        for (int i = 0; i < words.length - 1; i++) {
            if (!isOrder(words[i], words[i + 1], hash)) {
                return false;
            }
        }
        return true;
    }

    // 比较两个单词是否是按字典序排序的.
    private boolean isOrder(String s1, String s2, int[] hash) {

        int i = 0;
        for (; i < s1.length() && i < s2.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (hash[c1 - 'a'] < hash[c2 - 'a']) {
                return true;
            }
            if (hash[c1 - 'a'] > hash[c2 - 'a']) {
                return false;
            }
        }

        // 若两个字符串前半部分都相同, 短的应该在前
        return i == s1.length();
    }
}
