package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * 删除链表的节点
 */
public class Problem18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            if (cur.val == val) {
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
        }
        return dummy.next;
    }
}


