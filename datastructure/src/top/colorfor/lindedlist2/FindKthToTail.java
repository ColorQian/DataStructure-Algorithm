package top.colorfor.lindedlist2;

/**
 * 返回链表中倒数最后k个结点
 *
 * 注意：此题中链表的头节点即为第一个有效的节点
 */
public class FindKthToTail {
    public void add(Node head,Node node){

        Node cur = head;
        while (cur.next != null){
            cur = cur.next;
        }

        cur.next = node;
    }

    public void list(Node head) {

        if (head == null){
            System.out.println("链表为空！！！");
            return;
        }
        Node cur = head;
        while (cur != null) {
            System.out.printf("节点编号：%d \n", cur.val);
            cur = cur.next;
        }

    }

    /**输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
     * 如果该链表长度小于k，请返回一个长度为 0 的链表。
     *
     * @param head 输入链表的头节点
     * @param k 倒数第k个
     * @return 倒数第k个结点至尾节点的全部节点 的 头节点
     */
    public Node findKthToTail(Node head,int k){

        if (head == null){
            return null;
        }

        Node p1 = head;
        Node p2 = head;
        while (p1 != null && k > 0){
            p1 = p1.next;
            k--;
        }
        if (k > 0){
            return null;
        }
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    //---------------main-----------------
    public static void main(String[] args) {
        FindKthToTail list = new FindKthToTail();
        Node head = new Node(1);
        list.add(head,new Node(2));
        list.add(head,new Node(3));
        list.add(head,new Node(4));
        list.add(head,new Node(5));

        list.list(head);

        System.out.println("--------findKthToTail---------");
        Node newHead = list.findKthToTail(head, 3);
        list.list(newHead);


    }
}
