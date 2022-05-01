package com.jianzhi.master;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/0ynMMM/
 * 剑指 Offer II 039. 直方图最大矩形面积
 */
public class Question39 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] H = new int[len + 2];    // 将原数组首尾添加0
        for (int i = 0; i < len; i++) {
            H[i + 1] = heights[i];
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < H.length; i++) {
            while (!stack.isEmpty() && H[i] < H[stack.peek()]) {
                int mid = stack.pop();          // 弹出栈的作为mid
                int w = i - stack.peek() - 1;   // 这里只能使用stack.peek(),不能使用pop()
                res = Math.max(res, H[mid] * w); // 计算最大值
            }
            stack.push(i);
        }
        return res;
    }
}
