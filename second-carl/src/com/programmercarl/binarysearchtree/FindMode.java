package com.programmercarl.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 */
public class FindMode {
    int count;
    int maxCount;
    List<Integer> list;
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        count = 0;
        maxCount = 0;
        list = new ArrayList<>();
        pre = null;

        traversal(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public void traversal(TreeNode cur) {
        if (cur == null) return;

        traversal(cur.left); //左
        //中
        if (pre == null) {
            count = 1;   //第一个节点
        } else if (pre.val == cur.val) { //cur与前一个节点相同
            count++;
        } else {    //cur与前一个节点不同
            count = 1;
        }
        pre = cur;   //保留前一个节点

        if (count == maxCount) {  //多个众数
            list.add(cur.val);
        }

        if (count > maxCount) {  //新的众数
            maxCount = count;   //更新频次
            list.clear();     //清空list集合
            list.add(cur.val);
        }

        traversal(cur.right);  //右
    }
}
