package com.jianzhioffer2.master;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class Problem32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode cur = null;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                list.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return listToArray(list);
    }

    private int[] listToArray(ArrayList<Integer> list) {
        int size = list.size();
        int[] res = new int[size];

        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
