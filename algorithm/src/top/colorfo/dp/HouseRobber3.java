package top.colorfo.dp;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class HouseRobber3 {
    public int rob(TreeNode root) {

        //长度为2的数组，0:不偷当前节点，1:偷当前节点
        int[] res = robTree(root);

        return Math.max(res[0],res[1]);
    }

    private int[] robTree(TreeNode root) {

        if (root == null) return new int[]{0, 0};

        //后序递归遍历 左 右 中
        int[] left = robTree(root.left);   //左
        int[] right = robTree(root.right); //右

        //如果不偷当前节点，偷取的最大金额
        int val0 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        //如果偷当前节点，偷取的最大金额
        int val1 = root.val + left[0] + right[0];

        return new int[]{val0, val1};

    }
}
