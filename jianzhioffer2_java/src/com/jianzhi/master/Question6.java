package com.jianzhi.master;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/kLl5u1/
 * 剑指 Offer II 006. 排序数组中两个数字之和
 */
public class Question6 {
    /**
     * 解法一 : 哈希表
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                res[0] = map.get(numbers[i]);
                res[1] = i;
                break;
            }
            map.put(target - numbers[i], i);
        }
        return res;
    }

    /**
     * 方法二 : 二分查找
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] res = new int[2];
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{i, j};
    }
}
