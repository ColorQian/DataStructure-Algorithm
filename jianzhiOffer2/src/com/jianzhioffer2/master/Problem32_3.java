package com.jianzhioffer2.master;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 */
public class Problem32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            TreeNode cur = null;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (res.size() % 2 == 1) {
                    list.addFirst(cur.val);
                } else {
                    list.add(cur.val);
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
