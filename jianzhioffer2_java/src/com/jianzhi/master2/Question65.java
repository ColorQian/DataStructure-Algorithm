package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/iSwD2y/
 * 剑指 Offer II 065. 最短的单词编码
 */
public class Question65 {

    static class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String s : words) {
            TrieNode node = root;
            // 因为time和me算作一个字符串, 所以倒序构造前缀树
            // 例如 e m i t 这个路径就包含了emit和em
            for (int i = s.length() - 1; i >= 0; i--) {
                if (node.children[s.charAt(i) - 'a'] == null) {
                    node.children[s.charAt(i) - 'a'] = new TrieNode();
                }

                node = node.children[s.charAt(i) - 'a'];
            }
        }
        return root;
    }


    public int minimumLengthEncoding(String[] words) {
        TrieNode root = buildTrie(words);

        int[] total = new int[1];
        dfs(root, 1, total);
        return total[0];
    }

    public void dfs(TrieNode root, int len, int[] total) {
        boolean isLeaf = true;

        for (TrieNode node : root.children) {
            if (node != null) {
                isLeaf = false;
                dfs(node, len + 1, total);
            }
        }

        if (isLeaf) {
            total[0] += len;
        }
    }
}
