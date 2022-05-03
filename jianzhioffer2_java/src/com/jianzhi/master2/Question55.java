package com.jianzhi.master2;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/kTOapQ/
 * 剑指 Offer II 055. 二叉搜索树迭代器
 */

/**
 * 利用栈迭代 + 中序遍历的方式
 */
public class Question55 {
    /**
     * 利用栈迭代 + 中序遍历的方式
     */
    Stack<TreeNode> stack;
    TreeNode cur;
    public Question55(TreeNode root) {
        stack = new Stack<>();
        cur = root;
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;   // 左
        }

        cur = stack.pop();  // 中
        // 保存val
        int val = cur.val;
        cur = cur.right;   // 右

        // 返回val
        return val;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}

