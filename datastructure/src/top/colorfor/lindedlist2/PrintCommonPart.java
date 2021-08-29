package top.colorfor.lindedlist2;


public class PrintCommonPart {

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

    public Node getIntersectionNode(Node headA, Node headB) {
        Node l1 = headA;
        Node l2 = headB;

        while(l1 != l2){
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }

        return l1;
    }

    public static void main(String[] args) {

        Node node2 = new Node(2);
        Node node4 = new Node(4);
        PrintCommonPart printCommonPart = new PrintCommonPart();
        Node head1 = new Node(1);
        printCommonPart.add(head1,node2);
        printCommonPart.add(head1,node4);

        Node head2 = new Node(3);
        printCommonPart.add(head2,new Node(5));
        printCommonPart.add(head2,node2); //由于node2--->node4,即node2已经连接ndoe4，所以只需要添加node2即可


        printCommonPart.list(head1);
        System.out.println("----------");
        printCommonPart.list(head2);

        System.out.println("--------------");

        Node intersectionNode = printCommonPart.getIntersectionNode(head1, head2);
        printCommonPart.list(intersectionNode);

    }
}
