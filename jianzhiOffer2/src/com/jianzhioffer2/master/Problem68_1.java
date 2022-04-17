package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 */
public class Problem68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode min = p.val > q.val ? q : p;
        TreeNode max = p.val > q.val ? p : q;

        return traversal(root, min, max);
    }

    private TreeNode traversal(TreeNode root, TreeNode min, TreeNode max) {
        // 如果当前节点与min, max中的其中之一匹配
        if (root == null || root.val == min.val || root.val == max.val) return root;

        if (root.val > min.val && root.val < max.val) return root;          // 如果root.val 在(min, max)范围内
        else if (root.val > max.val) return traversal(root.left, min, max); // 向左递归
        else return traversal(root.right, min, max);                        // 向右递归
    }
}
