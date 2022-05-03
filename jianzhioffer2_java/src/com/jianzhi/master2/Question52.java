package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/NYBBNL/
 * 剑指 Offer II 052. 展平二叉搜索树
 */
public class Question52 {
    TreeNode pre = null;
    TreeNode head = null;
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return head;
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        if (pre == null) {
            head = root;       // 用来保存最左边的节点,当成链表的头节点
        }

        if (pre != null) {     // 这里pre 相当于双指针的一个处理
            pre.right = root;  // 题目要求只有一个右子节点
            root.left = null;  // 题目要求没有左子节点
        }
        pre = root;            // 更新pre指针

        inOrder(root.right);
    }
}
