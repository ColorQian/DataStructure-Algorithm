package com.jianzhi.master;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/PLYXKQ/
 * 剑指 Offer II 040. 矩阵中最大的矩形
 */
public class Question40 {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) return 0;

        int[] heights = new int[matrix[0].length()];
        int maxArea = 0;

        /**
         * 该方法将矩阵中的每一行, 都看做一个直方图, 然后求直方图中的最大矩形面积,
         * 最后得到矩阵中的最大矩形
         */
        for (String s : matrix) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] - '0' == 0) heights[i] = 0;
                else {
                    heights[i]++;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    /**
     * 该方法用来求直方图中的最大矩形面积
     */
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
