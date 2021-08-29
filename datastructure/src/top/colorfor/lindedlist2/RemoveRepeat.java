package top.colorfor.lindedlist2;


import java.util.HashSet;
import java.util.Set;

/**
 * 删除链表中的重复节点
 */
public class RemoveRepeat {

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

    public void removeRepeat(){
        if (head.next == null){
            System.out.println("链表为空！！！");
            return;
        }

        Set<Integer> set = new HashSet<>();

        Node cur = head.next;  //cur指向当前节点
        Node pre = head;   //cur指向当前节点的前一个节点

        while (cur != null){
            if (set.contains(cur.val)){  //如果哈希表中包含当前节点cur的值，就删除cur节点
                pre.next = cur.next;

            }else {     //如果不包含，则将cur节点的值加入到哈希表中
                set.add(cur.val);
                pre = cur;  //pre后移一位
            }

            cur = cur.next;
        }
    }

    public Node remove(int num){
        if (head.next == null){
            System.out.println("链表为空！！！");
            return head;
        }

        Node cur = head.next;  //cur指向当前节点
        Node pre = head;   //cur指向当前节点的前一个节点
        Node res = null;
        while (cur != null){
            if (cur.val == num){
                res = cur;
                pre.next = cur.next;

            }else {
                pre = cur;
            }

            cur = cur.next;
        }
        return res;
    }

    //-------------------main---------------------

    public static void main(String[] args) {
        RemoveRepeat remove = new RemoveRepeat();

        remove.add(new Node(1));
        remove.add(new Node(2));
        remove.add(new Node(2));
        remove.add(new Node(4));
        remove.add(new Node(5));
        remove.add(new Node(4));

        remove.removeRepeat();

        remove.list();

        System.out.println("---------------------");

        Node node = remove.remove(2);
        System.out.println("删除的节点"+node);

        remove.list();
    }


}
