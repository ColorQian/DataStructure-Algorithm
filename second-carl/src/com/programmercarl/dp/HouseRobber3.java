package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class HouseRobber3 {
    //后序遍历+长度为2的数组(记录当前节点偷与不偷 盗取的金额)
    public int rob(TreeNode root) {
        int[] result = traversal(root);
        return Math.max(result[0], result[1]);  //result[0] 表示不偷当前节点，result[1]表示偷当前节点
    }

    public int[] traversal(TreeNode cur) {  //1.确定递归返回值和函数参数
        if (cur == null) return new int[]{0, 0};   //2.递归终止条件

        //3.以下是单层递归逻辑
        //左
        int[] left = traversal(cur.left);  //递归左孩子，得到偷与不偷左孩子的结果
        //右
        int[] right = traversal(cur.right); //递归右孩子

        //中
        //不偷当前节点(左右孩子可以偷)
        /**
         如果不偷当前节点，那么左右孩子就可以偷，
         至于到底偷不偷一定是选一个最大的，
         所以：val0 = max(left[0], left[1]) + max(right[0], right[1]);
         */
        int val0 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        //偷当前节点(左右孩子不能偷)
        int val1 = cur.val + left[0] + right[0];

        return new int[]{val0, val1};
    }
}
