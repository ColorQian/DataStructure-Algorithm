package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 */
public class Problem68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 找到直接返回
        if (root == null || root == p || root == q) return root;

        // 递归左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 根据递归的结果return
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
