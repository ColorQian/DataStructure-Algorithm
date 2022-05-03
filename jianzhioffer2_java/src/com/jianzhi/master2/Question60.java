package com.jianzhi.master2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/g5c51o/
 * 剑指 Offer II 060. 出现频率最高的 k 个数字
 */
public class Question60 {
    /**
     * 方式一：小顶堆直接添加, 没有优化
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {

        // 使用HashMap做一个统计
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // 将HashMap统计结果(不同数字出现了几次),  放入到小顶堆中
        // 这样小顶堆中保存的就是前 k 个出现频率最高的Entry
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        // 从小顶堆中取出结果, 并返回结果
        int[] res = new int[k];
        for (int i = queue.size() - 1; i >= 0; i--) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }

    /**
     * 方式二：优化版
     * 添加之前, 先跟小顶堆的堆顶元素做个比较
     */
    public int[] topKFrequent2(int[] nums, int k) {

        // 使用HashMap做一个统计
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // 将HashMap统计结果(不同数字出现了几次),  放入到小顶堆中
        // 这样小顶堆中保存的就是前 k 个出现频率最高的Entry
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else {
                if (entry.getValue() > queue.peek().getValue()) {
                    queue.poll();
                    queue.offer(entry);
                }
            }
        }

        // 从小顶堆中取出结果, 并返回结果
        int[] res = new int[k];
        for (int i = queue.size() - 1; i >= 0; i--) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
