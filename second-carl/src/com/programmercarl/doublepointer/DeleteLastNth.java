package com.programmercarl.doublepointer;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class DeleteLastNth {
    /**
     * 先统计链表的节点个数，然后个数size - n,即可找到要删除节点的前面一个节点
     * 最后cur.next = cur.next.next,完成删除节点操作
     *
     * @param head 链表的头节点
     * @param n 倒数第n个
     * @return  返回删除后的链表的头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) return null;
        int size = 1;

        ListNode cur = head;
        while (cur.next != null) {
            size++;
            cur = cur.next;
        }

        int count = size - n;
        if (count == 0) return head.next;  //如果count == 0,则删除头节点
        cur = head;
        while (count > 1) {
            cur = cur.next;
            count--;
        }
        cur.next = cur.next.next;
        return head;
    }
}
