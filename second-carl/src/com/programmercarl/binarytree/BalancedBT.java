package com.programmercarl.binarytree;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 给定一个二叉树，判断它是否是高度平衡的二叉树
 *
 * 整体上是一个 左右中 后序遍历的过程，
 * 因为本题求的是高度，所以先找到叶子节点，然后一层一层向上返回
 * 最后得到以某个节点为根节点的二叉树的高度
 */
public class BalancedBT {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return getHeight(root) == -1 ? false : true;
    }

    // 返回以该节点为根节点的二叉树的高度，如果不是二叉搜索树了则返回-1
    int getHeight(TreeNode root) {
        if (root == null) return 0;

        int leftH = getHeight(root.left);
        if (leftH == -1) return -1;
        int rightH = getHeight(root.right);
        if (rightH == -1) return -1;

        //如果左右子树高度差大于1，则已经不是高度平衡的了，返回-1
        if (Math.abs(leftH - rightH) > 1) return -1;

        return Math.max(leftH, rightH) + 1;
    }
}
