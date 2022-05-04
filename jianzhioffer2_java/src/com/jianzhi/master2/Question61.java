package com.jianzhi.master2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/qn8gGX/
 * 剑指 Offer II 061. 和最小的 k 个数对
 */
public class Question61 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // 构造一个大顶堆, 排序规则是较大的数对, 放在堆顶
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] + b[1] - (a[0] + a[1]));

        // 遍历两个数组, 找到最小的 k 个数对, 保存到大顶堆中
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int[] temp = new int[2];
                if (queue.size() < k) {
                    temp[0] = nums1[i];
                    temp[1] = nums2[j];
                    queue.offer(temp);
                } else {
                    int sum = nums1[i] + nums2[j];
                    temp = queue.peek();
                    if (sum < temp[0] + temp[1]) {
                        queue.poll();
                        temp[0] = nums1[i];
                        temp[1] = nums2[j];
                        queue.offer(temp);
                    }
                }
            }
        }

        // 将堆中的数据存入List集合
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[2];
        while (!queue.isEmpty()) {
            nums = queue.poll();
            // Arrays.asList()该方法可以将数集, 转为List<Integer>.
            result.add(Arrays.asList(nums[0], nums[1]));
        }
        return result;
    }
}
