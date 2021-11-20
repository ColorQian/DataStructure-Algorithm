package com.programmercarl.stackqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //统计每个数出现的次数
        for (int value : nums) {
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
        }

        //按照map的value从小到大排序，相当于一个小顶堆
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();

        //将HashMap的Entry放入优先级队列，并利用每个数出现的次数按照小到大的顺序排列
        //而且保持优先级队列中的Entry的数目为k
        for (Map.Entry<Integer, Integer> entry : entries) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        //将最终结果放入result数组
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = priorityQueue.poll().getKey();
        }
        return result;
    }
}
