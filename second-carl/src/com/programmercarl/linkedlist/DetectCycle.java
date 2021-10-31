package com.programmercarl.linkedlist;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode low = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;

            if (low == fast) {   // 如果有环的话
                ListNode cur = head; //创建一个节点指向头节点
                while (cur != low) {
                    cur = cur.next;  //让头节点 与 慢指针同时移动，当两者相等时，就找到了环的入口
                    low = low.next;
                }
                return cur;
            }
        }
        return null;
    }
}
