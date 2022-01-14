package com.programmercarl.greedy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 * 无重叠区间
 */
public class OverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        //按照区间的起点从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {  //如果区间重复了
                result++;     //移除区间的数量+1
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);  //更新区间最小右边界
            }
        }
        return result;
    }
}
