package com.jianzhioffer2.master;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * 栈的压入、弹出序列
 */
public class Problem31 {
    /**
     * 一种朴素的解法：
     * 使用一个栈模拟压入、弹出序列，看是否满足要求
     *
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        if (len == 0) return true;

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < len; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
