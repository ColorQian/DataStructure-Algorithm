package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 剑指 Offer 22. 找到并返回 链表中 倒数第k个节点
 */
public class Problem22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k <= 0 || head == null) return null;

        int count = 0;
        ListNode cur = head;
        while (cur != null) {         // 统计节点个数
            cur = cur.next;
            count++;
        }

        if (k > count) return null;    // 超出范围，直接返回null
        if (k == count) return head;   // 直接返回头节点

        int step = count - k;
        ListNode p = head;            // 指针p 找到倒数k个，返回结果
        while (step > 0) {
            p = p.next;
            step--;
        }
        return p;
    }
}
