package top.colorfor.lindedlist2;

public class ReverseList {

    private Node head = new Node(-1);

    public void add(Node node){

        Node cur = head;
        while (cur.next != null){
            cur = cur.next;
        }

        cur.next = node;
    }

    public void list() {

        if (head.next == null) {
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
     * 反转单链表的方法
     */
    public void reverseList(){
        if(head.next == null || head.next.next == null ){
            System.out.println("不用反转该链表");
            return;
        }
        Node cur = head.next;
        Node next = null;
        Node newHead = new Node(-2);
        while(cur != null){  //遍历链表，cur为遍历到的当前节点
            next = cur.next;  //next 指向当前节点[cur]的下一个节点
            cur.next = newHead.next;  //当前节点[cur]的next域指向新的头节点的下一个节点
            newHead.next = cur;   //newHead的next域指向当前节点[cur]
            cur = next;   //cur后移一位
        }
        head.next = newHead.next;
    }


    //--------------main--------------------
    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        reverseList.add(new Node(1));
        reverseList.add(new Node(3));
        reverseList.add(new Node(2));
        reverseList.add(new Node(4));

        reverseList.list();

        System.out.println("---反转后的链表---");
        reverseList.reverseList();
        reverseList.list();
    }
}
