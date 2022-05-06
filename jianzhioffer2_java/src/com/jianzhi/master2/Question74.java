package com.jianzhi.master2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/SsGoHC/
 * 剑指 Offer II 074. 合并区间
 */
public class Question74 {
    public int[][] merge(int[][] intervals) {
        // 按照区间的左边 从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= list.peekLast()[1]) {   // 需要合并区间
                // 执行合并区间的操作
                int[] temp = list.remove(list.size() - 1);
                intervals[i][0] = temp[0];
                intervals[i][1] = Math.max(intervals[i][1], temp[1]);
                list.add(intervals[i]);

            } else {     // 不需要合并区间
                list.add(intervals[i]);
            }
        }
        int[][] res = new int[list.size()][2];
        return list.toArray(res);  // 将集合转为数组
    }
}
