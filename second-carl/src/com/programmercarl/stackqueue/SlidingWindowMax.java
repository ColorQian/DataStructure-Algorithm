package com.programmercarl.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    Deque<Integer> deque = new LinkedList<>();
    // 如果push的数值大于后端入口元素的数值，那么就将队列后端的数值弹出，
    // 直到push的数值小于等于队列后端入口元素的数值为止。
    // 这样就保持了队列里的数值是单调从大到小的了。
    public void pushIn(int value) {
        while (!deque.isEmpty() && value > deque.peekLast()) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public void popOut(int value) { //如果当前滑动窗口要移除的元素是队列头的元素，则移除之
        if (!deque.isEmpty() && value == deque.peekFirst()) {
            deque.pollFirst();
        }
    }

    public int getFront() {    //获取队列当前最大的元素
        return deque.peekFirst();
    }

    //-------------------------代码的逻辑如下----------------------
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            pushIn(nums[i]);   //先把前k个元素放入单调队列
        }
        result[0] = getFront();  //得到第一个滑动窗口的最大值
        for (int i = k; i < n; i++) {
            popOut(nums[i - k]);  //滑动窗口移除最前面的元素
            pushIn(nums[i]);      //滑动窗口加入最后的元素
            result[i - k + 1] = getFront();
        }
        return result;
    }

    //------------------
    public static void main(String[] args) {
        SlidingWindowMax windowMax = new SlidingWindowMax();
        windowMax.maxSlidingWindow(new int[]{1,3,1,2,0,5},3);
    }
}
