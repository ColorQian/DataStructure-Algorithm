package com.jianzhi.master2;

import com.jianzhi.master.ListNode;

/**
 * https://leetcode-cn.com/problems/7WHec2/
 * 剑指 Offer II 077. 链表排序
 *
 */
public class Question77 {
    public ListNode sortList(ListNode head) {
        // 链表为空, 或者只有一个节点就返回
        if (head == null || head.next == null) {
            return head;
        }

        ListNode head1 = head;
        ListNode head2 = split(head); // 找到后半部分的头节点返回

        // 分治
        head1 = sortList(head1);
        head2 = sortList(head2);

        // 合并链表
        return merge(head1, head2);
    }

    // 找到链表后半部分的头节点并返回
    public ListNode split(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 保存后半部分的头节点
        ListNode second = slow.next;

        // *****将前后两部分断开*****
        slow.next = null;

        return second;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }

            p = p.next;
        }

        p.next = head1 == null ? head2 : head1;

        return dummy.next;
    }
}
