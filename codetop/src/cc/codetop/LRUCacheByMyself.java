package cc.codetop;


import java.util.HashMap;

/**
 * 千万注意，在向双向链表中添加节点Node，以及向HashMap中添加<key, Node>时
 * 一定要保证两者添加的是同一个Node(引用或者说地址得一样！！！)
 */
public class LRUCacheByMyself {

    int capacity;
    DoubleLinkedlist cache = new DoubleLinkedlist();
    HashMap<Integer, Node> map = new HashMap<>();
    public LRUCacheByMyself(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        //如果包含返回val的值,并且刷新双向链表
        int val = map.get(key).val;
        makeRecently(key);
        return val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            Node node = new Node(key, val);

            cache.delete(map.get(key)); //删除旧的
            cache.addFirst(node);  //加入新的

            map.put(key, node); //更新map中node的值

            return;
        }

        //map中不包含key
        Node newNode = new Node(key, val);
        map.put(key, newNode);  //将新的key,node加入map
        cache.addFirst(newNode);       //双向链表中加入node

        //检查容量是否超出
        if (map.size() > capacity) {
            int oldKey = cache.deleteLast();
            map.remove(oldKey);
        }
    }

    public void makeRecently(int key) {
        Node node = map.get(key);

        cache.delete(node);
        cache.addFirst(node);
    }


}

class DoubleLinkedlist {
    Node head;
    Node tail;

    public DoubleLinkedlist() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.pre = head;
    }

    public void addFirst(Node node) {  //在双向链表头部添加节点(准确来说是虚拟头节点之后)
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    public int delete(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;

        return node.key;
    }

    public int deleteLast() {
        if (head.next == tail) return -1;

        return delete(tail.pre);
    }
}

/**
 * 定义带有前驱和后继的节点
 */
class Node {
    int key;
    int val;

    Node pre;
    Node next;

    public Node() {}

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}