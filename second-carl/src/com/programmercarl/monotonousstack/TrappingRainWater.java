package com.programmercarl.monotonousstack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    /**
     * 方法一：单调栈
     */
    public int trap(int[] height) {
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int rain = 0;
        stack.push(0);
        for (int i = 1; i < len; i++) {
            if (height[i] < height[stack.peek()]) {     //当前柱子高度 小于 栈顶元素对应的柱子高度
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {  //当前柱子高度 等于 栈顶元素对应的柱子高度
                stack.pop();
                stack.push(i);
            } else {                                     //当前柱子高度 大于 栈顶元素对应的柱子高度
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int w = i - stack.peek() - 1;
                        int h = Math.min(height[i], height[stack.peek()]) - height[mid];
                        rain += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return rain;
    }

    /**
     * 解法二：双指针
     */
    public int trap2(int[] height) {
        int rain = 0;
        int len = height.length;

        for (int i =0; i < len; i++) {
            if (i == 0 || i == len - 1) continue; //第一个 和 最后一个柱子不装雨水

            int LHeight = height[i];
            int RHeight = height[i];
            for (int r = i + 1; r < len; r++) {   //取当前列右边最高的柱子
                if (height[r] > RHeight) RHeight = height[r];
            }
            for (int l = i - 1; l >= 0; l--) {   //取当前列左边最高的柱子
                if (height[l] > LHeight) LHeight = height[l];
            }

            int h = Math.min(RHeight, LHeight) - height[i];  //统计当前列装的雨水
            if (h > 0) rain += h;
        }
        return rain;
    }

    /**
     * 解法三：动态规划
     */
    public int trap3(int[] height) {
        int len = height.length;
        int rain = 0;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];

        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++) {  //从左向右遍历，得到当前柱子左边的最大高度
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }

        maxRight[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {  //从右向左遍历，得到当前柱子右边的最大高度
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        for (int i = 1; i < len - 1; i++) {  //第一根和最后一根柱子不装雨水
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0) rain += count;
        }
        return rain;
    }

}
