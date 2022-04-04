package com.jianzhioffer2.master;

/**
 * 反转二叉树
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/submissions/
 */
public class Problem27 {
    public TreeNode mirrorTree(TreeNode root) {

        invert(root);

        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) return;

        // 中  (交换根节点的左右孩子)
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 左
        invert(root.left);

        // 右
        invert(root.right);
    }
}
