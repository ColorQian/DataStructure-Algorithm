package com.jianzhioffer2.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 从尾到头打印链表
 */
public class PrintLinkedListFromTail {
    public int[] reversePrint(ListNode head) { //首先遍历链表，将链表中的节点值，放入List中
        if (head == null) return new int[0];

        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            list.add(cur.val);
            count++;
            cur = cur.next;
        }
        return listToArray(list, count);

    }

    public int[] listToArray(List<Integer> list, int count) { //遍历List，将List中的值，倒序放入数组中
        int[] result = new int[count];
        for (int num : list) {
            count--;
            result[count] = num;
        }
        return result;
    }
}
