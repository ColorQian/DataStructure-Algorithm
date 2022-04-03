package com.jianzhioffer2.master;

public class Problem24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        // dummy.next = head;  这里千万不能接head
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
