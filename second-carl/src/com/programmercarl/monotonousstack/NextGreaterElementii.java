package com.programmercarl.monotonousstack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 */
public class NextGreaterElementii {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        if (len == 1) return new int[]{-1};
        int[] result = new int[len];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < len * 2; i++) {
            if (nums[i % len] <= nums[stack.peek()]) {
                stack.push(i % len);
            } else {
                while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                    result[stack.peek()] = nums[i % len];
                    stack.pop();
                }
                stack.push(i % len);
            }
        }
        return result;
    }
}
