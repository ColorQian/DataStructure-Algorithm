package com.programmercarl.monotonousstack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int[] height = new int[heights.length + 2];
        int len = height.length;
        for (int i = 1; i < len - 1; i++) {  //更新heights数组，新建一个height数组，相当于在heights数组首尾补0
            height[i] = heights[i - 1];
        }
        int result = 0;
        Stack<Integer> stack = new Stack<>();  //根据题意，从栈顶到栈底的下标对应的元素，应该是递减的
        stack.push(0);
        for (int i = 1; i < len; i++) {
            if (height[i] > height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int right = i;
                        int left = stack.peek();
                        int w = right - left - 1;
                        int h = height[mid];
                        result = Math.max(result, w * h);
                    }
                }
                stack.push(i);
            }
        }
        return result;
    }
}
