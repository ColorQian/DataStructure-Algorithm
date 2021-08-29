package top.colorfor.lindedlist2;

public class CircleLinkedlist {

    public Node findIn(Node head){
        if (head == null){
            return null;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast){
                Node index1 = head;
                Node index2 = slow;

                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }

        return null;
    }
}