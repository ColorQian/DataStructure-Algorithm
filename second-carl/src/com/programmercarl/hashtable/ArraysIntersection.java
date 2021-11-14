package com.programmercarl.hashtable;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class ArraysIntersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return null;

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums1) {     //将 nums1 的数据存放到HashSet中
            hashSet.add(i);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums2) {
            if (hashSet.contains(i)) {  //如果hashSet中包含nums2中的元素，则为交集，加入到新的HashSet中
                set.add(i);
            }
        }

        int[] result = new int[set.size()];
        int count = 0;
        for (Integer integer : set) {  //遍历包含交集的HashSet集合，加入到结果数组中
            result[count++] = integer;
        }

        return result;
    }
}
