package com.programmercarl.linkedlist;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 给定val值，删除该值对应的节点
 */
public class RemoveNode {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next; //如果相等，把cur节点删除
            } else {
                pre = cur;   //如果不相等，pre向后移动一位
            }

            cur = cur.next;  //cur指针后移
        }
        return newHead.next;
    }
}
