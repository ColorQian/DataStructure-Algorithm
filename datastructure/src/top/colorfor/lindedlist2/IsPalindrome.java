package top.colorfor.lindedlist2;

import java.util.Stack;

/**
 * 判断链表是否是回文结构
 */
public class IsPalindrome {

    private Node head = new Node(-1);

    public void add(Node node){

        Node cur = head;
        while (cur.next != null){
            cur = cur.next;
        }

        cur.next = node;
    }


    public boolean isPalindrome(){
        if (head.next == null){
            System.out.println("链表为空！！！");
            return false;
        }

        Stack<Node> stack = new Stack<>();
        Node cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        cur = head.next;
        Node popNode = null;
        boolean flag = true;
        while (!stack.isEmpty() && cur != null){
            popNode = stack.pop();
            if (popNode.val != cur.val){
                flag = false;
            }
            cur = cur.next;
        }

        return flag;
    }

    //--------------main----------------

    public static void main(String[] args) {
        IsPalindrome palindrome = new IsPalindrome();
        palindrome.add(new Node(1));
        palindrome.add(new Node(2));
        palindrome.add(new Node(2));
        palindrome.add(new Node(1));

        boolean palindrome1 = palindrome.isPalindrome();
        System.out.println(palindrome1);
    }

}
