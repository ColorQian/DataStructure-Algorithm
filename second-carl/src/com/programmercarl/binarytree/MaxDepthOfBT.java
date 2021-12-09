package com.programmercarl.binarytree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 二叉树的最大深度
 */
public class MaxDepthOfBT {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return depth;
    }
}
