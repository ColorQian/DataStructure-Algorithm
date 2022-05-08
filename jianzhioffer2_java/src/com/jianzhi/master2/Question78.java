package com.jianzhi.master2;

import com.jianzhi.master.ListNode;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/vvXgSW/
 * 剑指 Offer II 078. 合并排序链表
 */
public class Question78 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode cur = null;
        while (!minHeap.isEmpty()) {
            cur = minHeap.poll();
            p.next = cur;
            p = p.next;
            if (cur.next != null) {
                minHeap.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
