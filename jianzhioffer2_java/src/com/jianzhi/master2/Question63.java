package com.jianzhi.master2;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/UhWRSj/
 * 剑指 Offer II 063. 替换单词
 */
public class Question63 {

    // 前缀树的节点
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    // 首先利用字典里的词根构造一个前缀树
    public TrieNode buildTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();

        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }

                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        return root;
    }

    // 查找前缀树中是否存在某个单词的前缀
    public String findPrefix(TrieNode root, String word) {
        TrieNode node = root;
        StringBuilder builder = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (node.isWord || node.children[c - 'a'] == null) {
                break;
            }
            builder.append(c);
            node = node.children[c - 'a'];
        }

        return node.isWord ? builder.toString() : "";
    }

    // 替换单词
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildTrie(dictionary);

        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            String s = findPrefix(root, strs[i]);
            if (s.length() != 0) {
                strs[i] = s;     // 用词根代替原单词
            }
        }
        return String.join(" ", strs);
    }
}
