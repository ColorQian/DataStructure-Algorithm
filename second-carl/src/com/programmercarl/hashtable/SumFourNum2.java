package com.programmercarl.hashtable;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 */
public class SumFourNum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int a : nums1) {
            for (int b : nums2) {
                int count1 = a + b;
                if (!map.containsKey(count1)) {
                    map.put(count1, 1);
                } else {
                    int val = map.get(count1);
                    map.put(count1, ++val);
                }
            }
        }

        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int c : nums3) {
            for (int d : nums4) {
                int count2 = 0 - (c + d);
                if (map.containsKey(count2)) {
                    result += map.get(count2);
                }
            }
        }
        return result;
    }
}
