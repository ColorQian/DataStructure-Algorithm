package com.jianzhi.master2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/LwUNpT/
 * 剑指 Offer II 045. 二叉树最底层最左边的值
 */
public class Question45 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = null;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (i == 0) res = cur.val;

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return res;
    }
}
