package com.jianzhi.master;


/**
 * https://leetcode-cn.com/problems/SLwz0R/
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 */
public class Question21 {
    /**
     * 基于双指针的思想, 实现一趟扫描, 删除链表的倒数第k个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode front = head;
        ListNode back = dummy;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }

        while (front != null) {
            front = front.next;
            back = back.next;
        }

        //当front指针为空时，说明走到了链表的末尾，此时back指针在目标节点的前一个
        back.next = back.next.next;

        return dummy.next;
    }
}
