package com.programmercarl.linkedlist;

public class RemoveNth {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;

        int size = 0;
        while (cur.next != null) { //统计出链表的长度
            cur = cur.next;
            size++;
        }

        int step = size - n;
        ListNode pre = dummyHead;
        while (step > 0) {  //令pre指向要删除节点的前面一个
            pre = pre.next;
            step--;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }
}
