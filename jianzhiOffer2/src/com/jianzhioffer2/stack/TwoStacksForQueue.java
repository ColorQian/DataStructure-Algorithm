package com.jianzhioffer2.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 用两个栈实现队列
 */
public class TwoStacksForQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public TwoStacksForQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        pushToPop();

        if (!out.isEmpty()) {
            return out.pop();
        }
        return -1;
    }

    public void pushToPop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}
