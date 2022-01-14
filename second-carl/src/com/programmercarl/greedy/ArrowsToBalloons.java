package com.programmercarl.greedy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * 用最少的箭射爆气球
 */
public class ArrowsToBalloons {
    public int findMinArrowShots(int[][] points) {
        //按照气球的起始位置从小到大排序
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] < o2[0]) return -1;
            else if (o1[0] > o2[0]) return 1;
            else return 0;
        });

        int result = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) { //气球i和气球i-1不挨着，一定需要一支箭
                result++;
            } else {   //气球i和气球i-1挨着,更新重叠气球最小右边界
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }
        return result;
    }
}
