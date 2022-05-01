package com.jianzhi.master2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question44 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = null;
            int size = queue.size();
            int maxInLevel = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                maxInLevel = Math.max(maxInLevel, cur.val);

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            res.add(maxInLevel);
        }
        return res;
    }
}
