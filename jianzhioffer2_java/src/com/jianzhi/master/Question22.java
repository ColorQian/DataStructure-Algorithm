package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/c32eOV/
 * 剑指 Offer II 022. 链表中环的入口节点
 */
public class Question22 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {  // 链表有环
                ListNode helper = head;

                while (helper != slow) {
                    slow = slow.next;
                    helper = helper.next;
                }
                return helper;  // 返回链表入口
            }
        }
        return null;
    }
}
