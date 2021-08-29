package top.colorfor.lindedlist2;

/**
 * 合并两个有序的单链表
 */
public class MergeLinkedList {

    public void add(Node head,Node node){

        Node cur = head;
        while (cur.next != null){
            cur = cur.next;
        }

        cur.next = node;
    }

    public void list(Node head) {

        if (head.next == null){
            System.out.println("链表为空！！！");
            return;
        }
        Node cur = head.next;
        while (cur != null) {
            System.out.printf("节点编号：%d \n", cur.val);
            cur = cur.next;
        }

    }

    /**
     * 合并两个单链表
     * @param head1 第一个链表的头节点
     * @param head2 第二个链表的头节点
     * @return 返回新的链表的头节点
     */
    public Node merge(Node head1,Node head2){
        if (head1.next == null && head2.next == null){
            System.out.println("两个链表为空！！！");
            return null;
        }

        Node newHead = new Node(-1);
        Node cur = newHead;
        head1 = head1.next;
        head2 = head2.next;

        while (head1 != null && head2 != null){
            if (head1.val < head2.val){
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            }else if (head2.val < head1.val){
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }else {
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;

                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }

        while (head1 != null){
            cur.next = head1;
            cur = cur.next;
            head1 = head1.next;
        }

        while (head2 != null){
            cur.next = head2;
            cur = cur.next;
            head2 = head2.next;
        }

        return newHead;
    }

    //----------------main--------------
    public static void main(String[] args) {
        MergeLinkedList merge = new MergeLinkedList();

        Node head1 = new Node(-1);
        Node head2 = new Node(-1);

        merge.add(head1,new Node(0));
        merge.add(head1,new Node(2));
        merge.add(head1,new Node(3));
        merge.add(head1,new Node(7));

        merge.add(head2,new Node(1));
        merge.add(head2,new Node(3));
        merge.add(head2,new Node(5));
        merge.add(head2,new Node(7));
        merge.add(head2,new Node(9));

        Node merge1 = merge.merge(head1, head2);

        merge.list(merge1);
    }
}
