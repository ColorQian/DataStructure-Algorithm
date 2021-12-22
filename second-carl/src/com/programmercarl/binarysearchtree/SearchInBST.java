package com.programmercarl.binarysearchtree;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * 二叉搜索树中的搜索
 */
public class SearchInBST {
    //方法一：递归法
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (val == root.val) return root;

        if (val < root.val) return searchBST(root.left, val);
        if (val > root.val) return searchBST(root.right, val);

        return null;
    }

    //方法二：迭代法
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) root = root.left;
            else if (val > root.val) root = root.right;
            else return root;
        }
        return root;
    }
}
