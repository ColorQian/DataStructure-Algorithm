package cc.codetop;

public class TestListNodeAddress {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node1;
        node1.next = node2;

        ListNode dummy = head;
        dummy.next = new ListNode(3);
        System.out.println(head);
    }
}
