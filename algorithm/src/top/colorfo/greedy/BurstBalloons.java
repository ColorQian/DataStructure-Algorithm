package top.colorfo.greedy;

import com.sun.deploy.pings.Pings;

import java.util.Arrays;
import java.util.Comparator;

public class BurstBalloons {

    public int findMinArrowShots(int[][] points) {

        if (points.length == 0) return 0;

        int result = 1;
        Arrays.sort(points, new Comparator<int[]>() { //按照左边界排序,从小到大排序
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) return -1;
                else if (o1[0] > o2[0]) return 1;
                else return 0;
            }
        });

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {  //两个气球如果不挨着
                result++;  //需要一支箭

            } else {  //气球i和i-1挨着
                points[i][1] = Math.min(points[i-1][1],points[i][1]); // 更新重叠气球最小右边界
                                                                      // 即：取两者之中较小的右边界作为气球i的右边界
            }
        }
        return result;
    }

}
