package com.programmercarl.binarysearchtree;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树
 */
public class ConvertToSumTree {
    /**
     * 使用 右 中 左 的递归遍历顺序 + 双指针
     */
    TreeNode pre;
    public TreeNode convertBST(TreeNode root) {
        pre = null;
        traversal(root);

        return root;
    }

    public void traversal(TreeNode cur) {
        if (cur == null) return;

        traversal(cur.right);  //右
        if (pre != null) {     //中
            cur.val += pre.val;
        }
        pre = cur;
        traversal(cur.left);  //左
    }
}
