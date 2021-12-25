package com.programmercarl.binarysearchtree;

/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 */
public class InsertIntoBST {
    /**
     *方法一
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        traversal(root, val);
        return root;
    }
    public void traversal(TreeNode cur, int val) {
        if (cur == null) return;

        if (cur.left == null && cur.right == null) {        //叶子节点
            if (val < cur.val) cur.left = new TreeNode(val);
            else if (val > cur.val) cur.right = new TreeNode(val);
        } else if (cur.left == null && val < cur.val) {    //左子树为空
            cur.left = new TreeNode(val);
        } else if (cur.right == null && val > cur.val) {   //右子树为空
            cur.right = new TreeNode(val);
        }

        //左右子树都不为空，递归左右子树
        if (val > cur.val) traversal(cur.right, val);
        if (val < cur.val) traversal(cur.left, val);
    }

    /**
     *方法二
     * 到这里，大家应该能感受到，如何通过递归函数返回值完成了新加入节点的父子关系赋值操作了，
     * 下一层将加入节点返回，本层用root->left或者root->right将其接住。
     */
    public TreeNode insertIntoBST2(TreeNode cur, int val) {
        if (cur == null) return new TreeNode(val);

        if (val > cur.val) cur.right = insertIntoBST(cur.right, val);
        if (val < cur.val) cur.left = insertIntoBST(cur.left, val);

        return cur;
    }
}
