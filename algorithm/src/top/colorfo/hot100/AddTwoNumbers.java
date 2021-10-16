package top.colorfo.hot100;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    //该方法未被LeetCode AC
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int number1 = getNumber(l1);
        int number2 = getNumber(l2);

        int sum = number1 + number2;
        ListNode head = covertToList(sum);
        return head;
    }

    //将求和的结果转换为一个链表
    private ListNode covertToList(int sum) {

        ListNode head = new ListNode();
        while (sum > 0) {
            int temp = sum % 10;
            sum = sum / 10;

            //创建一个节点，用来保存当前的数
            ListNode node = new ListNode(temp);

            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
        return head.next;
    }

    //将链表转换为数字
    private int getNumber(ListNode l1) {
        String temp = "";
        while (l1 != null) {
            temp = l1.val + temp;
            l1 = l1.next;
        }
        return Integer.valueOf(temp);
    }
}
