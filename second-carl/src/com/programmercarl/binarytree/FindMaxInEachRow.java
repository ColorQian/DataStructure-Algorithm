package com.programmercarl.binarytree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 *
 * 找出二叉树每一层的最大值
 */
public class FindMaxInEachRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            result.add(max);
        }
        return result;
    }
}
