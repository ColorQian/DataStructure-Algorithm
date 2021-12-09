package com.programmercarl.binarytree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 *
 * 求二叉树的每一层的平均值(使用层序遍历模板，将每一层节点求和，再除以节点个数即可)
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            result.add(sum / size);
        }
        return result;
    }
}
