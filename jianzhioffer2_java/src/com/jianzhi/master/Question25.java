package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/lMSNwu/
 * 剑指 Offer II 025. 链表中的两数相加
 */
public class Question25 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        int carry = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        // 下面的代码为两数相加的逻辑
        while (p1 != null || p2 != null || carry == 1) {
            int n1 = p1 != null ? p1.val : 0;
            int n2 = p2 != null ? p2.val : 0;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;

            int sum = n1 + n2 + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
        }
        return reverseList(dummy.next);
    }

    // 反转链表
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
