package cc.codetop;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer = dummy;  //pointer 指向要反转的那k个节点的前面一个节点
        while (pointer != null) {
            ListNode nodeCount = pointer;  // nodeCount 用来计数, 看一下是否剩余 k 个节点来反转
            for (int i = 0; i < k && nodeCount != null; i++) {
                nodeCount = nodeCount.next;
            }
            if (nodeCount == null) break;
            
            // 接下来开始反转 k 个一组链表
            ListNode pre = null;
            ListNode cur = pointer.next;
            ListNode next = null;
            for (int i = 0; i < k; i++) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            // 由于前面的反转操作, 将反转过的 k 个节点 和 原来的链表断开了,需要接一下
            ListNode tail = pointer.next;  // 相当于当前反转过的k个节点的尾节点
            tail.next = cur;
            pointer.next = pre;
            pointer = tail;        // 让pointer指向tail节点, 为下一次反转做准备
        }
        return dummy.next;
    }
}
