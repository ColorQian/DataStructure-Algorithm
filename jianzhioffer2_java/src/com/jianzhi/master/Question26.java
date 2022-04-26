package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/LGjMqU/
 * 剑指 Offer II 026. 重排链表
 */
public class Question26 {
    public void reorderList(ListNode head) {
        if (head.next == null) return;
        if (head.next.next == null) return;

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转后半部分
        ListNode back = reverseList(slow.next);
        // 将前半部分和后半部分断开
        slow.next = null;

        ListNode p1 = head;
        ListNode p2 = back;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (p1 != null && p2 != null) {
            p.next = p1;
            p1 = p1.next;
            p = p.next;

            p.next = p2;
            p2 = p2.next;
            p = p.next;
        }
        if (p1 != null) p.next = p1;

        head = dummy.next;
    }

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
