package com.programmercarl.binarytree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * 判断二叉树是否是对称的
 */
public class SymmetricTree {

    /**
     *方法一：迭代法，使用队列实现
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            //如果都为空，则跳过本次循环，进行下一次循环判断
            if (left == null && right == null) continue;

            //不满足对称的情况，直接返回false
            if (left != null && right == null) return false;
            if (right != null && left == null) return false;
            if (left.val != right.val) return false;

            queue.offer(left.left);   //加入左节点的左孩子
            queue.offer(right.right); //加入右节点的右孩子
            queue.offer(right.left);  //加入右节点的左孩子
            queue.offer(left.right);  //加入左节点的右孩子
        }
        return true;
    }

    /**
     *方法二：递归法
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return false;

        return compare(root.left, root.right);
    }
    private boolean compare(TreeNode left, TreeNode right) {
        //如果都为空，则返回true
        if (left == null && right == null) return true;

        //不满足对称的情况，直接返回false
        if (left != null && right == null) return false;
        if (right != null && left == null) return false;
        if (left.val != right.val) return false;

        boolean outSide = compare(left.left, right.right);  //递归比较左节点的左孩子，右节点的右孩子
        boolean inSide = compare(right.left, left.right);   //递归比较右节点的左孩子，左节点的右孩子

        return outSide && inSide;  //返回内侧和外侧比较的结果
    }
}
