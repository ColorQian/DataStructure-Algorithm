package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/z1R5dt/
 * 剑指 Offer II 066. 单词之和
 */
public class Question66 {

    static class TrieNode {
        TrieNode[] children;
        int value;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Question66() {
        root = new TrieNode();
    }

    // 将字符串加入到前缀树中
    public void insert(String key, int val) {
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.value = val;
    }

    // 利用getSum递归遍历查找指定前缀的字符串的value
    public int sum(String prefix) {

        TrieNode node = root;

        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return 0;
            }
            node = node.children[c - 'a'];
        }
        // 这里传入的是前缀字符串最后一个字符对应的节点
        return getSum(node);
    }

    // 递归遍历查找符合前缀要求的完整字符串, 从而得到它们的value
    // 接着求和返回
    public int getSum(TrieNode root) {
        if (root == null)
            return 0;

        int result = root.value;
        for (TrieNode child : root.children) {
            result += getSum(child);
        }

        return result;
    }
}
