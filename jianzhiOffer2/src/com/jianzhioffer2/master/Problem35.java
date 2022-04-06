package com.jianzhioffer2.master;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/submissions/
 * 剑指 Offer 35. 复杂链表的复制
 */
public class Problem35 {
    /**
     * 使用Hash映射将 老 新 节点组合在一起
     * 再次遍历老的复杂链表，通过map.get(老) 拿到新的节点
     * 从而可以构造新节点之间的关系。
     */
    public Node copyRandomList(Node head) {
        if (head == null) return head;

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            // 让新的节点之间互相连接
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next, random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

