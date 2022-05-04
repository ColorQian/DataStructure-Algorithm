package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/QC3q1f/
 * 剑指 Offer II 062. 实现前缀树
 */
public class Trie {

    // 静态内部类, 前缀树的节点
    static class TrieNode {
        TrieNode[] children;  // TrieNode的子节点
        boolean isWord;       // 用来标识是否找到了完整的单词

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 向前缀树中添加字符
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            // 深度遍历
            node = node.children[c - 'a'];
        }
        // 标记一个完整的单词
        node.isWord = true;
    }

    // 查找是否存在完整的单词
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }

            // 深度遍历
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }

    // 查找是否存在某个前缀
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }

            // 深度遍历
            node = node.children[c - 'a'];
        }
        return true;
    }
}

