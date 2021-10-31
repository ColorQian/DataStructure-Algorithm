package com.programmercarl.linkedlist;


class MyLinkedList {

    int len;
    LinkedNode head;
    class LinkedNode {
        int val;
        LinkedNode next;
        public LinkedNode(){}
        public LinkedNode(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        head = new LinkedNode();
    }

    //注意index与len的关系，index >= len就不满足要求
    public int get(int index) {
        if (index >= len || index < 0) return -1;

        LinkedNode node = head.next;
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node.val;
    }

    //头插法
    public void addAtHead(int val) {
        LinkedNode node = new LinkedNode(val);
        node.next = head.next;
        head.next = node;
        len++;
    }

    //尾插法加到最后
    public void addAtTail(int val) {
        LinkedNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new LinkedNode(val);
        len++;
    }

    //在任意位置加入
    public void addAtIndex(int index, int val) {
        if (index == len) addAtTail(val);
        else if (index > len) return;
        else if (index < 0) addAtHead(val);
        else {
            LinkedNode pre = head;
            LinkedNode cur = head.next;
            while (index > 0) {
                pre = cur;
                cur = cur.next;
                index--;
            }
            LinkedNode node = new LinkedNode(val);
            node.next = cur;
            pre.next = node;
            len++;
        }
    }

    //删除第index个节点，从0开始
    //注意index与len的关系，index >= len就不满足要求
    public void deleteAtIndex(int index) {
        if (index >= len || index < 0) return;

        LinkedNode pre = head;

        //用一个指针也可以完成删除的操作
        while (index > 0) {
            pre = pre.next;
            index--;
        }
        pre.next = pre.next.next;
        len--;
    }
}
