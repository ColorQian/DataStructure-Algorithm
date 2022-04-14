package com.jianzhioffer2.master;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Problem59_2 {
    MyDeque2 deque = new MyDeque2();
    Queue<Integer> queue = new LinkedList<>();
    public Problem59_2() {

    }

    public int max_value() {
        return deque.getMax();
    }

    public void push_back(int value) {
        queue.offer(value);
        deque.push(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        deque.pop(queue.peek());
        return queue.poll();
    }
}

/**
 * 本题的关键就是构造一个双端队列
 */
class MyDeque2 {
    Deque<Integer> deque;

    public MyDeque2() {
        deque = new LinkedList<>();
    }

    public void push(int val) {
        while (!deque.isEmpty() && val > deque.peekLast()) {
            deque.pollLast();
        }
        deque.offer(val);
    }

    public void pop(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    public int getMax() {
        if (deque.isEmpty()) return -1;

        return deque.peek();
    }
}
