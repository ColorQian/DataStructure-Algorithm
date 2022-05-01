package com.jianzhi.master2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/H8086Q/
 * 剑指 Offer II 042. 最近请求次数
 */
public class Question42 {
    Queue<Integer> queue;
    public Question42() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        int left = t - 3000;
        while (!queue.isEmpty() && left > queue.peek()) {
            queue.poll();
        }

        return queue.size();
    }
}
