package com.jianzhioffer2.master;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 *
 * 参考carl哥的题解
 */
public class Problem59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        MyDeque deque = new MyDeque();

        int len = nums.length;
        int[] res = new int[len - k + 1];
        int count = 0;

        // 先将数组前k个元素加入队列
        for (int i = 0; i < k; i++) {
            deque.push(nums[i]);
        }
        res[count++] = deque.getWindowMax();

        // 处理数组中剩下的元素
        for (int i = k; i < len; i++) {
            // 将滑动窗口的左边收缩一格，也就是移除窗口左边的元素
            deque.pop(nums[i - k]);

            // 将滑动窗口右边扩大一格，就是滑动窗口加入一个元素，加到双端队列
            deque.push(nums[i]);

            // 保存滑动窗口的最大值
            res[count++] = deque.getWindowMax();
        }
        return res;
    }
}

class MyDeque {
    // 构造一个单调队列，用户存放当前窗口中的最大值
    // 双端队列和普通的队列类似，不同的是，它有更丰富的接口，比如：deque.peekLast()、deque.pollLast()
    Deque<Integer> deque;
    public MyDeque() {
        deque = new LinkedList<>();
    }

    public void push(int val) {
        // 如果新加入的元素比队尾元素大，那么就将队尾元素弹出，直到新加入元素小于等于队尾元素，或者队列为空
        while (!deque.isEmpty() && val > deque.peekLast()) {
            deque.pollLast();
        }
        deque.offer(val);
    }

    public void pop(int val) {
        // 如果当前滑动窗口，向前移动时，要移出窗口的值，恰好是最大值，那么将队列头元素移除
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    // 获取当前滑动窗口的最大值，也就是返回队列的头元素
    public int getWindowMax() {
        return deque.peek();
    }

}
