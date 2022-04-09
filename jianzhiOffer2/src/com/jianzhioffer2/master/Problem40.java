package com.jianzhioffer2.master;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 剑指 Offer 40. 最小的k个数
 */
public class Problem40 {
    /**
     * 使用大顶堆 找 最小的k个数
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length;
        if (len == 0 || k == 0) return new int[0];

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);

        //queue.offer(arr[0]);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < len; i++) {
            if (!queue.isEmpty() && arr[i] <= queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        int[] res = new int[k];
        int count = 0;
        while (count < k) {
            res[count++] = queue.poll();
        }
        return res;
    }
}
