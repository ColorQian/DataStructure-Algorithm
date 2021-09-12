package top.colorfo.greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1: 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]] 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0],o2[0]));//按照左边界排序
        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= result.getLast()[1]) { //如果有重叠的部分
                int start = result.getLast()[0];
                int end = Math.max(result.getLast()[1],intervals[i][1]);

                result.removeLast();     //先把result集合中的取出来
                result.add(new int[]{start,end});  //再加入新的数组进到result集合中

            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
