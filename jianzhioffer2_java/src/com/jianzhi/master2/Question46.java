package com.jianzhi.master2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/WNC0Lk/
 * 剑指 Offer II 046. 二叉树的右侧视图
 */
public class Question46 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = null;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (i == size - 1) res.add(cur.val);

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return res;
    }
}
