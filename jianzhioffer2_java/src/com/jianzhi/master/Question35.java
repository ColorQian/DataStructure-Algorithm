package com.jianzhi.master;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/569nqc/
 * 剑指 Offer II 035. 最小时间差
 */
public class Question35 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) return 0;

        // 将每个出现的分钟数, 存储到hash数组中
        // 下标表示不同的分钟数, 值表示该分钟数是否出现过
        boolean[] minuteFlag = new boolean[1440];
        for (String s : timePoints) {
            String[] strs = s.split(":");
            int minute = Integer.valueOf(strs[0]) * 60 + Integer.valueOf(strs[1]);

            if (minuteFlag[minute]) return 0;

            minuteFlag[minute] = true;
        }

        return helper(minuteFlag);
    }

    // 该方法用来找出最小的差值
    public int helper(boolean[] minuteFlag) {
        int len = minuteFlag.length;

        // 用来保存前一个时间点
        int pre = -1;
        // 用来保存当前时间点 和 前一个时间点的分钟差值
        int minDiff = len;

        // 下面两个变量是为了考虑[00:00, 23:59]这种情况
        int first = len;
        int last = -1;
        for (int i = 0; i < len; i++) {
            if (minuteFlag[i]) {
                if (pre >= 0) {
                    minDiff = Math.min(i - pre, minDiff);
                }

                pre = i;
                first = Math.min(first, i);
                last = Math.max(last, i);
            }
        }
        minDiff = Math.min(first + len - last, minDiff);
        return minDiff;
    }
}
