package com.jianzhi.master;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/aMhZSa/
 * 剑指 Offer II 027. 回文链表
 */
public class Question27 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if (list.get(l) != list.get(r))
                return false;

            l++;
            r--;
        }
        return true;
    }
}
