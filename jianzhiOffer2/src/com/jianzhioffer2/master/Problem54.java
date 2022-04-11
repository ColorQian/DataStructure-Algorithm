package com.jianzhioffer2.master;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class Problem54 {
    PriorityQueue<Integer> queue;
    int k;
    public int kthLargest(TreeNode root, int k) {
        // 创建一个小顶堆
        queue = new PriorityQueue<>((a, b) -> a - b);
        this.k = k;

        traversal(root);
        return queue.poll();
    }

    private void traversal(TreeNode root) {
        if (root == null) return;

        traversal(root.left);   // 左

        if (queue.isEmpty() || root.val >= queue.peek()) {  // 中
            queue.offer(root.val);
        }
        // 保证小顶堆大小始终 <= k
        if (queue.size() > k) {
            queue.poll();
        }

        traversal(root.right);  // 右
    }
}
