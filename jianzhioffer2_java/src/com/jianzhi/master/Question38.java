package com.jianzhi.master;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/iIQa4I/
 * 剑指 Offer II 038. 每日温度
 */
public class Question38 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
