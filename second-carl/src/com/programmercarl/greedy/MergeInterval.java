package com.programmercarl.greedy;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        //按照区间的左边从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);       //把第一个区间加入到list
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {  //如果区间有重叠
                intervals[i][0] = intervals[i - 1][0];  //更新第i个区间的左边
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]); //更新第i个区间的右边
                list.remove(list.size() - 1);  //将结果集list的最后一个区间移除
                list.add(intervals[i]);   //将第i个区间加入到list
            } else {
                list.add(intervals[i]);  //没有重叠直接加入第i个区间
            }
        }
        return list.toArray(new int[list.size()][2]);  //将链表转为数组
    }
}
