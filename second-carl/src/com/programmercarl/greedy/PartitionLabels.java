package com.programmercarl.greedy;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/partition-labels/
 * 划分字母区间(这题的思路不太好想)
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] hash = new int[26];
        char[] str = s.toCharArray();
        //获取每一个字母最后出现的位置
        for (int i = 0; i < str.length; i++) {
            hash[str[i] - 'a'] = i;
        }

        int left = 0;
        int right= 0;
        /**
         * 从头遍历字符，并更新字符的最远出现下标，
         * 如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
         */
        for (int i = 0; i < str.length; i++) {
            right = Math.max(right, hash[str[i] - 'a']);

            if (i == right) {
                result.add(right - left + 1);
                left = i + 1;
            }
        }
        return result;
    }
}
