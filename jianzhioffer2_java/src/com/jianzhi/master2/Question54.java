package com.jianzhi.master2;

/**
 * https://leetcode-cn.com/problems/w6cpku/
 * 剑指 Offer II 054. 所有大于等于节点的值之和
 */
public class Question54 {
    TreeNode pre = null;
    public TreeNode convertBST(TreeNode root) {
        reInOrder(root);

        return root;
    }

    public void reInOrder(TreeNode root) {
        if (root == null) return;

        reInOrder(root.right);

        if (pre != null) {
            root.val += pre.val;
        }
        pre = root;

        reInOrder(root.left);
    }
}
