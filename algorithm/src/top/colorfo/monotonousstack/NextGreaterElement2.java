package top.colorfo.monotonousstack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 */
public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < len * 2; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                result[stack.peek()] = nums[i % len];
                stack.pop();
            }
            stack.push(i % len);
        }
        return result;
    }
}
