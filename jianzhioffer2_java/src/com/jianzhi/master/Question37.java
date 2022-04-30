package com.jianzhi.master;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/XagZNi/
 * 剑指 Offer II 037. 小行星碰撞
 */
public class Question37 {
    // 4 5 -6 4 8 -5
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int n : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -n) {
                stack.pop();
            }

            if (!stack.isEmpty() && n < 0 && stack.peek() == -n) {
                stack.pop();
            } else if (stack.isEmpty() || n > 0 || stack.peek() < 0) {
                stack.push(n);
            }

        }

        int[] res = new int[stack.size()];
        int count = res.length - 1;
        while (!stack.isEmpty()) {
            res[count--] = stack.pop();
        }
        return res;
    }
}
