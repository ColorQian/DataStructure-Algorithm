package com.jianzhi.master;

/**
 * https://leetcode-cn.com/problems/3u1WK4/
 * 剑指 Offer II 023. 两个链表的第一个重合节点
 */
public class Question23 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = p1 != null ? p1.next : headB;
            p2 = p2 != null ? p2.next : headA;
        }
        return p1;
    }
}
