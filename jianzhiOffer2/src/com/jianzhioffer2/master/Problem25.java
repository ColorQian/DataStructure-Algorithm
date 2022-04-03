package com.jianzhioffer2.master;

/**
 * 合并两个排序链表
 */
public class Problem25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }

        }
        if (p1 == null) p.next = p2;
        if (p2 == null) p.next = p1;

        return dummy.next;
    }
}
