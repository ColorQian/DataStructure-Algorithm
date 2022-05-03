package com.jianzhi.master2;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/jBjn9C/
 * 剑指 Offer II 059. 数据流的第 K 大数值
 */
public class Question59 {

    PriorityQueue<Integer> queue;
    int k;
    public Question59(int k, int[] nums) {
        queue = new PriorityQueue<>((a, b) -> a - b);  // 求 第 k 大, 构造一个小顶堆
        this.k = k;
        for (int n : nums) {
            queue.offer(n);

            if (queue.size() > k)
                queue.poll();
        }

    }

    public int add(int val) {
        queue.offer(val);

        if (queue.size() > k)
            queue.poll();

        return queue.peek();
    }
}
