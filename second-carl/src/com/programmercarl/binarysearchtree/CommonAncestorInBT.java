package com.programmercarl.binarysearchtree;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class CommonAncestorInBT {
    //代码很短，但是内涵丰富
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) return root;

        root.left = lowestCommonAncestor(root.left, p, q);
        root.right = lowestCommonAncestor(root.right, p, q);

        if (root.left == null && root.right == null) return null;
        else if (root.left == null) return root.right;
        else if (root.right == null) return root.left;

        return root;  //root.left != null && root.right != null
    }
}
