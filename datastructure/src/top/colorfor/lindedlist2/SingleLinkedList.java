package top.colorfor.lindedlist2;

public class SingleLinkedList {

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

    /**在单链表中删除倒数第k个节点
     *
     * @param lastKth 倒数第k个
     * @return 删除的倒数第k个节点
     */
    public Node removeLastKthNode(int lastKth){
        Node cur = head;

        if (head.next == null || lastKth < 1){
            System.out.println("链表为空或者参数输入有误！！！");
            return cur;
        }

        //遍历链表，每移动一次，lathKth的值就减去1
        while (cur.next != null){
            cur = cur.next;
            lastKth--;
        }

        Node res = null;

        if (lastKth > 0){ //lastKth的值大于链表的长度，直接返回
            return cur;
        }else if(lastKth == 0){ // 此时，lastKth就是第一个节点
            this.head = this.head.next;
            return this.head;
        }else {   //如果lastKth < 0
            cur = this.head;
            while (lastKth != 0){
                cur = cur.next;
                lastKth++;
            }
            res = cur.next; //将要删除的节点赋值给res,用来返回

            cur.next = cur.next.next;

        }

        return res;
    }

    //------------------------------main-----------------

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();

        linkedList.add(new Node(1));
        linkedList.add(new Node(2));
        linkedList.add(new Node(3));
        linkedList.add(new Node(4));
        linkedList.add(new Node(5));

        Node node = linkedList.removeLastKthNode(3);

        linkedList.list();
        System.out.println("-------------");
        System.out.println(node);
    }
}
