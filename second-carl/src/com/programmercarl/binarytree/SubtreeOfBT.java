package com.programmercarl.binarytree;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 *
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 */
public class SubtreeOfBT {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean left = false;
        if (root.left != null) {
            left = isSubtree(root.left, subRoot); //递归比较 root的左子树 和 subRoot
        }

        boolean right = false;
        if (root.right != null) {
            right = isSubtree(root.right, subRoot); //递归比较 root的右子树 和 subRoot
        }
        return  left || right || compare(root, subRoot); //这里的compare用来比较root 和 subRoot是否相同
    }

    //用来比较两棵二叉树是否相同，相同返回true，不同返回false
    boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left != null && right == null) return false;
        else if (left == null && right != null) return false;
        else if (left.val != right.val) return false;

        //程序走到这里，说明left.val == right.val
        boolean leftSide = compare(left.left, right.left);
        boolean rightSide = compare(left.right, right.right);
        return leftSide && rightSide;
    }
}
