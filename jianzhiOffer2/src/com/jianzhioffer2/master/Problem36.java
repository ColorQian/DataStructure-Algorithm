package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class Problem36 {
    /**
     * 使用双指针
     * 别忘了最后，第一和最后一个节点也要相连
     */
    Node pre = null;
    Node head = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return head;

        inorder(root);

        // 第一个 和 最后一个节点 也要相连
        head.left = pre;
        pre.right = head;

        return head;
    }

    private void inorder(Node cur) {
        if (cur == null) return;

        inorder(cur.left);   // 左

        if (pre == null) {
            // 保留第一个节点
            head = cur;
        }

        if (pre != null) {   // 中
            cur.left = pre;
            pre.right = cur;
        }
        pre = cur;

        inorder(cur.right);  // 右
    }

    class Node {
        int val;
        Node left;
        Node right;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }
    }
}


