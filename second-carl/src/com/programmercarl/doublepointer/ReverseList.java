package com.programmercarl.doublepointer;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {
    //使用头插法反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode();
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
