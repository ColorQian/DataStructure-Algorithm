package com.jianzhioffer2.master;

import java.util.PriorityQueue;


/**
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * 剑指 Offer 41. 数据流中的中位数
 *
 * 参考解答：
 * https://mp.weixin.qq.com/s/oklQN_xjYy--_fbFkd9wMg
 */
public class Problem41 {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public Problem41() {
        // small里面存放的数比较小，但是它是一个大顶堆
        small = new PriorityQueue<>((a, b) -> b - a);

        // larget 里面存放的数比较大，但是它是一个小顶堆
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if (small.size() >= large.size()) { // 说明large中的元素较少，所以往large中放入
            small.offer(num);
            large.offer(small.poll());
        } else {                            // 说明small中的元素较少，所以往small中放入
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        // 偶数个情况
        if (small.size() > large.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }

        // 奇数个情况
        return (small.peek() + large.peek()) / 2.0;
    }
}
