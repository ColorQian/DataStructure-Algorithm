package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/Qv1Da2/
 * 剑指 Offer II 028. 展平多级双向链表
 */
public class Question28 {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node head) {
        // 常规遍历链表, 需要使用的当前节点和下一个节点
        Node node = head;
        Node next = null;

        // 用于保存当前这一级的最后一个节点
        Node tail = null;
        while (node != null) {
            next = node.next;
            if (node.child != null) {
                // 孩子链表的头
                Node child = node.child;
                // 孩子链表的尾
                Node childTail = dfs(child);

                // 注意将当前节点的孩子节点置空
                node.child = null;

                // 将当前节点和孩子节点头相连
                node.next = child;
                child.prev = node;

                // 将孩子链表的尾节点和next节点相连
                // 注意next有可能为空
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                tail = childTail;
            } else {
                tail = node;
            }
            node = next;
        }
        return tail;
    }
}
