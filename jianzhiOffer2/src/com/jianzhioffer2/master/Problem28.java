package com.jianzhioffer2.master;

/**
 * 对称的二叉树
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 */
public class Problem28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return traversal(root.left, root.right);
    }

    private boolean traversal(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left.val != right.val) return false;

        boolean outSide = traversal(left.left, right.right);
        boolean inSide = traversal(left.right, right.left);

        return inSide && outSide;
    }
}
