package com.programmercarl.linkedlist;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseLinkedlist {

    //使用头插法反转链表，使用双指针
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode pre = head;
        ListNode cur = head;
        ListNode newHead = new ListNode();
        while (cur != null) {
            cur = cur.next;
            pre.next = newHead.next;
            newHead.next = pre;
            pre = cur;

        }
        return newHead.next;

    }

}
