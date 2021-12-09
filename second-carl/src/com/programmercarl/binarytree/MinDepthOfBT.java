package com.programmercarl.binarytree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 二叉树的最小值
 */
public class MinDepthOfBT {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                //如果一个节点的左右孩子都为null，则找到了二叉树的最小深度
                if (cur.left == null && cur.right == null) return depth;

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return depth;
    }
}
