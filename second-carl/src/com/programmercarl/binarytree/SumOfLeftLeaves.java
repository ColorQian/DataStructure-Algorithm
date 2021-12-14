package com.programmercarl.binarytree;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * 求二叉树所有的左叶子之和
 *
 * 本题的关键：搞清楚 左叶子 的定义
 */
public class SumOfLeftLeaves {
    /**
     * 方法一：递归
     */
    int result = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        traversal(root);

        return result;
    }
    void traversal(TreeNode cur) { //递归三部曲 + 前序遍历(中左右)
        if (cur == null) return;

        if (cur.left != null && cur.left.left == null && cur.left.right == null) { //左叶子节点的定义
            result += cur.left.val;
        }

        traversal(cur.left);
        traversal(cur.right);
    }

    /**
     * 方法二:使用栈迭代
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;

        int result = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) { //使用前序遍历的方式(中 左 右)
            TreeNode cur = stack.pop();

            if (cur.left != null && cur.left.left == null && cur.left.right == null) { //左叶子节点的定义
                result += cur.left.val;
            }

            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return result;
    }
}
