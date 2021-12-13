package com.programmercarl.binarytree;

/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 *
 * 统计完全二叉树的节点个数
 */
public class CountNodes {
    /**
     * 方法一：递归
     */
    int result = 0;
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        traversal(root);

        return result;
    }
    void traversal(TreeNode cur) {  //1.返回值和参数
        if (cur == null) return;    //2.递归终止条件

        //3.单层递归逻辑
        result++;   //中
        traversal(cur.left);  //左
        traversal(cur.right);  //右
    }

    //方法二：层序遍历
    //代码略
}
