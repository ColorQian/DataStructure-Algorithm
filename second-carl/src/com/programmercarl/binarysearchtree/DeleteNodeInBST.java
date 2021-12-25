package com.programmercarl.binarysearchtree;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * 给定一个二叉搜索树的根节点 root 和一个值 key，
 * 删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 */
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val == key) {  //找到要删除的节点了
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {            //左右子树都不为空

                //核心:把右子树挂到左子树的最右边
                TreeNode leftTreeRight = root.left;
                while (leftTreeRight.right != null) {
                    leftTreeRight = leftTreeRight.right;
                }
                leftTreeRight.right = root.right;
                return root.left;
            }

        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}
