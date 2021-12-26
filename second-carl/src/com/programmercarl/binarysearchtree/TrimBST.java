package com.programmercarl.binarysearchtree;

/**
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 * 修剪二叉搜索树
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low) {   //如果根节点不在范围内，左右孩子可能在，修剪左 或 右孩子
                                //1.root.val < low  2.root.val > high
            root.right = trimBST(root.right, low, high);
            return root.right;
        } else if (root.val > high) {
            root.left = trimBST(root.left, low, high);
            return root.left;

        } else {               //如果根节点在范围内，则要修剪 左孩子 和 右孩子，最后return root
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}
