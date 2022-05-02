package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/3Etpl5/
 * 剑指 Offer II 049. 从根节点到叶节点的路径数字之和
 */
public class Question49 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        traversal(root, root.val);
        return sum;
    }

    private void traversal(TreeNode root, int preSum) {
        // 遇到叶子节点, 收集结果
        if (root.left == null && root.right == null) {
            sum += preSum;
            return;
        }

        if (root.left != null) {
            traversal(root.left, 10 * preSum + root.left.val);
        }

        if (root.right != null) {
            traversal(root.right, 10 * preSum + root.right.val);
        }
    }
}
