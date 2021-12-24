package com.programmercarl.binarysearchtree;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 */
public class MinDifferInBST {

    /**
     *方法一：转换为有序数组
     * 把二叉搜索树转换成有序数组，然后遍历一遍数组，就统计出来最小差值了
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        int result = Integer.MAX_VALUE;
        int temp = -1;
        for (int i = 1; i < list.size(); i++) {
            temp = list.get(i) - list.get(i - 1);
            result = temp < result ? temp : result;
        }
        return result;
    }
    void traversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }

    //方法二:递归中的双指针
    TreeNode pre = null;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference2(TreeNode root) {
        traversal2(root);
        return res;
    }
    private void traversal2(TreeNode cur) {
        if (cur == null) return;

        traversal2(cur.left);//左
        if (pre != null) {
            res = Math.min(res, cur.val - pre.val);
        }
        pre = cur; //记录前一个
        traversal2(cur.right);
    }

    //方法三：迭代的中序遍历+双指针
    public int getMinimumDifference3(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int result = Integer.MAX_VALUE;

        while (!st.empty() || cur != null) { //这里加 "|| cur != null"就是为了第一步能进入while循环
            if (cur != null) { // 指针来访问节点，访问到最底层
                st.push(cur); // 将访问的节点放进栈
                cur = cur.left;                // 左
            } else {
                cur = st.pop();

                if (pre != null) {              // 中
                    result = Math.min(result, cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right;               // 右
            }
        }
        return result;
    }

}
