package com.jianzhi.master;

import com.jianzhi.entity.Node;

public class Question29 {
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
        } else if (head.next == head) {
            head.next = insertNode;
            insertNode.next = head;
        } else {
            insertCore(head, insertNode);
        }
        return head;
    }

    private void insertCore(Node head, Node node) {
        Node cur = head;
        Node next = cur.next;
        Node biggest = head;

        // 试图找到插入的间隙, 以及最大的节点
        while (!(cur.val <= node.val && next.val >= node.val) && next != head) {
            cur = next;
            next = cur.next;

            if (cur.val >= biggest.val) {
                biggest = cur;
            }
        }

        // 如果存在插入间隙
        if (cur.val <= node.val && next.val >= node.val) {
            cur.next = node;
            node.next = next;

        // 不存在插入间隙, 将node节点, 插入到最大节点之后
        } else {
            next = biggest.next;
            biggest.next = node;
            node.next = next;
        }
    }
}
