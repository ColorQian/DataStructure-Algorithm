package com.programmercarl.doublepointer;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;

            if (low == fast) { //如果有环的话
                low = head;
                while (low != fast) {
                    low = low.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
