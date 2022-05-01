package com.jianzhi.master2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/qIsx9U/
 * 剑指 Offer II 041. 滑动窗口的平均值
 */
public class Question41 {

    int size;
    Queue<Integer> queue;
    double sum = 0.0;
    public Question41(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        sum += val;
        queue.offer(val);

        if (queue.size() > size) {
            sum -= queue.poll();
        }

        return sum / queue.size();
    }
}
