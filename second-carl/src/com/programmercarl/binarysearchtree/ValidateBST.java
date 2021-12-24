package com.programmercarl.binarysearchtree;

import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 验证二叉搜索树
 */
public class ValidateBST {
    /**
     * 方法一：转换为有序数组
     *利用中序遍历，将二叉树转化为一个序列，判断该序列是否是严格递增的
     * (若前后两个值相等则也不是BST)
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) <= result.get(i - 1)) return false; //若前后两个值相等则也不是BST
        }
        return true;
    }
    void traversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        traversal(root.left, list);

        list.add(root.val);

        traversal(root.right, list);
    }

    /**
     *方法二：递归中的双指针
     */
    boolean flag = true;
    TreeNode pre = null;
    public boolean isValidBST2(TreeNode root) {
        traversal(root);
        return flag == true;
    }
    void traversal(TreeNode cur) {
        if (cur == null) return;

        traversal(cur.left);  //左
        if (pre != null) {  //中
            if (pre.val >= cur.val) flag = false;
        }
        pre = cur;  //保留前一个节点
        traversal(cur.right);
    }
}
