package com.programmercarl.monotonousstack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * 每日温度
 */
public class DailyTemperatures {
    /**
     * 解法一：暴力解法
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        if (len == 1) return new int[]{0};

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 解法二：单调栈
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        if (len == 1) return new int[]{0};
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();  //stack存放下标  保持栈顶到栈底应该是递增的
        stack.push(0);
        for (int i = 1; i < len; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) { //若满足递增的情况，则下标直接入栈
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }
}
