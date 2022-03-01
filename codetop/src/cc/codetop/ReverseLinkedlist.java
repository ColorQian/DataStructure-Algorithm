package cc.codetop;

public class ReverseLinkedlist {
    //使用头插法反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);  //虚拟头节点

        ListNode cur = head;    //新建两个辅助节点，都指向head节点
        ListNode next = head;

        while (cur != null) {
            next = cur.next;   //1.next指向cur.next,为了保存cur的下一个节点
            cur.next = dummy.next; //2.cur节点的next域 指向 dummy的下一个节点
            dummy.next = cur;   // 3.dummy的next域 指向 cur节点
            cur = next;        // 4.cur节点后移一位(因为第1步已经用next保存了cur的下一个节点),cur后移一位是为了反转下一个节点做准备
        }
        return dummy.next;
    }
}
