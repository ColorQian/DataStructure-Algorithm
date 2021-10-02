package top.colorfo.monotonousstack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class DailyTemperatures {
    //方法一：单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        if (len == 1) return new int[1];

        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  //栈中放入数组的下标
        for (int i = 1; i < len; i++) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
        }
        return result;
    }

    //方法二：暴力求解
    public int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        if (len == 1) return new int[1];

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
}
