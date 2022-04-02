package com.test;

public class TestListNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        /*ListNode pointer = node2;
        pointer.next = null;

        System.out.println(node1);*/

        ListNode pointer = node3;
        pointer = null;
        System.out.println(node1);

    }
}
