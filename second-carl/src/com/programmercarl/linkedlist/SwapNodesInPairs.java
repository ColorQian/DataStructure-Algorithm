package com.programmercarl.linkedlist;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 两两交换链表中的节点
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur.next != null && cur.next.next != null) {  //判断后面两个节点是否为空，为交换做准备
            ListNode temp1 = cur.next; //临时节点，储存那些，由于指向变动，而不被指向的节点
            ListNode temp2 = cur.next.next.next; //临时节点，储存那些不被指向的节点

            cur.next = cur.next.next;  //虚拟头节点指向 后面 第二个 (注意:此时cur.next已经不再指向原本的后面第一个节点，而是原本的后面第二个)
            cur.next.next = temp1;  // 虚拟头节点后面第二个节点 指向 第一个
            temp1.next = temp2;     //虚拟头节点后面第一个节点 指向 第三个

            cur = cur.next.next;  //后移两位，为下一次做准备

        }
        return dummyHead.next;
    }
}
