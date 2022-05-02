package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/jC7MId/
 * 剑指 Offer II 051. 节点之和最大的路径
 */
public class Question51 {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;

        traversal(root);

        return max;
    }

    private int traversal(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(traversal(root.left), 0);
        int right = Math.max(traversal(root.right), 0);

        max = Math.max(max, left + right + root.val);

        return Math.max(left, right) + root.val; //向上返回只能返回一边
    }
}
