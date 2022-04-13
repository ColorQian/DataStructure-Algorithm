package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/submissions/
 * 判断二叉树是否是平衡的
 */
public class Problem55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return getHeight(root) == -1 ? false : true;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        int heightL = getHeight(root.left);  // 递归左孩子，得到左孩子的深度
        if (heightL == -1) return -1;       // 如果左孩子不满足平衡二叉树，返回-1

        int heigthR = getHeight(root.right);
        if (heigthR == -1) return -1;

        if (Math.abs(heightL - heigthR) > 1) return -1;  // 如果左右子树的深度差，超过1，那么不是平衡二叉树
        return Math.max(heightL, heigthR) + 1;          //获取左右子树深度的最大值 + 1，然后向上返回
    }
}
