package com.leetcode.hot;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 * 2. 两数相加
 */
public class LC02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = reverseList(l1);
        ListNode h2 = reverseList(l2);

        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while (p1 != null || p2 != null || carry == 1) {
            int n1 = p1 == null ? 0 : p1.val;
            int n2 = p2 == null ? 0 : p2.val;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }

            int sum = n1 + n2 + carry;
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            carry = sum / 10;
        }
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);

        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
