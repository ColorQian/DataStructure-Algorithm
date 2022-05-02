package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/pOCWxh/
 * 剑指 Offer II 047. 二叉树剪枝
 */
public class Question47 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return root;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
