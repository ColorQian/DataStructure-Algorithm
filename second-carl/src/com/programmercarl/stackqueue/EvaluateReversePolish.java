package com.programmercarl.stackqueue;

import java.util.Stack;
/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolish {

    /**
     * 适合用栈操作运算：遇到数字则入栈；
     * 遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {

            if (s.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 + num1);
            } else if (s.equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (s.equals("*")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 * num1);
            } else if (s.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                Integer num = Integer.valueOf(s);
                stack.push(num);
            }
        }

        return stack.pop();
    }
}
