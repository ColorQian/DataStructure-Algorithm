package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/UHnkqh/
 * 剑指 Offer II 024. 反转链表
 */
public class Question24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
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
