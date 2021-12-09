package com.programmercarl.binarytree;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * 二叉树的右视图(使用层序遍历的模板，将每层的最后一个节点加入集合即可)
 */
public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);

                if (i == size - 1) {
                    result.add(cur.val);
                }
            }
        }
        return result;
    }
}
