package com.programmercarl.doublepointer;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 */
public class IntersectionOfTwoLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            //这样的写法有没有交点都能判断(不能写成p1.next == null ? headB : p1.next)
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
