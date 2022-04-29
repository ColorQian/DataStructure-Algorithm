package com.jianzhi.highfrequency;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/OrIXps/
 * 剑指 Offer II 031. 最近最少使用缓存
 */
public class Question31 {
    HashMap<Integer, Node> map;
    DLinkedList cache;
    int capacity;
    public Question31(int capacity) {
        map = new HashMap<>();
        cache = new DLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // 更新缓存
        Node node = map.get(key);
        cache.delete(node);
        cache.addFirst(node);

        return node.val;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (map.containsKey(key)) {
            // 更新缓存
            Node old = map.get(key);
            cache.delete(old);
            cache.addFirst(newNode);
            // 更新map
            map.put(key, newNode);
            return;
        }

        // 新加入一个节点
        map.put(key, newNode);
        cache.addFirst(newNode);

        if (map.size() > capacity) {
            int oldKey = cache.deleteLast();
            map.remove(oldKey);
        }
    }
}

class DLinkedList {
    Node head;
    Node tail;

    public DLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.pre = head;
    }

    // 新加入节点插入链表的头部
    public void addFirst(Node node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    public int delete(Node node) {
        int key = node.key;

        node.pre.next = node.next;
        node.next.pre = node.pre;

        return key;
    }

    public int deleteLast() {
        if (head.next == tail) return -1;

        int key = tail.pre.key;

        delete(tail.pre);

        return key;
    }


}

class Node {
    int key;
    int val;
    Node pre;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
