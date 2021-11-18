package com.programmercarl.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
    Queue<Integer> queue;
    public QueueToStack() {
        queue = new LinkedList<>();
    }

    //加入的时候，直接放入队列即可
    public void push(int x) {
        queue.offer(x);
    }

    //模拟栈的后入先出: 保留队列尾的最后一个元素，
    // 从队列头开始，让元素依次出队列，再依次入队列
    //此时，队列的头元素即为之前的队列尾的那个元素
    public int pop() {
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
        return queue.poll();
    }

    //利用已经实现的pop()方法，先让队列尾的元素出队列，
    //这样就可以拿到队列尾的元素，在把它加入队列即可(这样不破坏队列的队形)
    public int top() {
        Integer result = this.pop();
        queue.offer(result);
        return result;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
