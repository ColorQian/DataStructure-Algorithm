package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/US1pGT/
 * 剑指 Offer II 064. 神奇的字典
 */
public class Question64 {
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode () {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Question64() {
        root = new TrieNode();
    }

    // 构建前缀树
    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }

                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
    }

    // 在前缀树中搜索, (根据深度优先的顺序搜索前缀树中的每条路径)
    public boolean search(String searchWord) {
        return dfs(root, searchWord, 0, 0);
    }

    // 根据 深度优先的顺序 搜索前缀树中的 每条路径
    public boolean dfs(TrieNode cur, String word, int i, int edit) {
        if (cur == null)
            return false;

        if (cur.isWord && i == word.length() && edit == 1)
            return true;

        if (i < word.length() && edit <= 1) {
            boolean found = false;
            for (int j = 0; j < 26 && !found; j++) {
                int next = j == word.charAt(i) - 'a' ? edit : edit + 1;
                found = dfs(cur.children[j], word, i + 1, next);
            }

            return found;
        }
        return false;
    }
}
