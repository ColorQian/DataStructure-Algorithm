package com.programmercarl.binarytree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 * N叉树的层序遍历
 */
public class NAryTreeLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                temp.add(cur.val);
                if (cur.children != null) {
                    for (Node child : cur.children) {
                        queue.offer(child);
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }
}
