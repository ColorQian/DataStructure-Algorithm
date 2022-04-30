package com.jianzhi.master;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/8Zf90G/
 * 剑指 Offer II 036. 后缀表达式
 */
public class Question36 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1 + n2);
            } else if (s.equals("-")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 - n1);
            } else if (s.equals("*")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1 * n2);
            } else if (s.equals("/")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 / n1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.peek();
    }
}
