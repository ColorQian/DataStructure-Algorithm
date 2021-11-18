package com.programmercarl.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class StackToQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public StackToQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        dumpStack1();
        return stack2.pop();
    }

    public int peek() {
        dumpStack1();
        return stack2.peek();
    }

    public boolean empty() {
        dumpStack1();
        return stack2.isEmpty() && stack1.isEmpty();
    }

    //如果stack2为空，那么将stack1中的元素全部放到stack2中
    public void dumpStack1() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }


}
