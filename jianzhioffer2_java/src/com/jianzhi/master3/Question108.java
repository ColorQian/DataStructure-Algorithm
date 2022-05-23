package com.jianzhi.master3;

import java.util.*;

/**
 * https://leetcode.cn/problems/om3reC/
 * 剑指 Offer II 108. 单词演变
 *
 * 参考题解: https://programmercarl.com/0127.%E5%8D%95%E8%AF%8D%E6%8E%A5%E9%BE%99.html#java
 */
public class Question108 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 将wordList转为HashSet, 加快查找速度
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        String cur = "";
        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (int i = 0; i < cur.length(); i++) {
                char[] chars = cur.toCharArray();
                for (int k = 0; k < 26; k++) {
                    chars[i] = (char) (k + 'a');
                    String newWord = String.valueOf(chars);

                    if (newWord.equals(endWord)) {
                        return map.get(cur) + 1;
                    }

                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) {
                        map.put(newWord, map.get(cur) + 1);
                        queue.offer(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
