package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/P5rCT8/
 * 剑指 Offer II 053. 二叉搜索树中的中序后继
 */
public class Question53 {
    /**
     * 还是基于双指针的一种写法
     */
    TreeNode pre = null;
    TreeNode target = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder(root, p);
        return target;
    }

    public void inOrder(TreeNode root, TreeNode p) {
        if (root == null) return;

        inOrder(root.left, p);

        if (pre != null && pre.val == p.val) {
            target = root;
            //return;
        }
        pre = root;

        inOrder(root.right, p);
    }
}
