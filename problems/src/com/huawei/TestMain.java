package com.huawei;

import java.util.Arrays;

/**
 * 工人在工地上搬砖。这里有N堆砖，第i堆中有stones[i] 块砖。监工已经离开了，将在 H 小时后回来。
 * 工人可以决定她搬砖的速度 K（单位：块/小时）。每个小时，她将会选择一堆砖，从中搬掉K块。
 * 如果这堆砖少于K块，他将搬完这堆所有的砖，然后这一小时内不会再搬更多的砖。
 * 工人喜欢慢慢搬，但仍然想在监工回来前搬完所有的砖。返回他可以在H小时内搬完所有的砖的最小速度K（K 为整数）。
 *
 *
 * 示例 1：
 * 输入: stones= [3,6,7,11], H = 8
 * 输出: 4
 *
 * 示例 2：
 * 输入: stones= [30,11,23,4,20], H = 5
 * 输出: 30
 *
 * 示例 3：
 * 输入: stones= [30,11,23,4,20], H = 6
 * 输出: 23
 *
 *
 提示：
 1 <= stones.length <= 10^4
 stones.length <= H <= 10^9
 1 <= stones[i] <= 10^9
 *
 */
public class TestMain {
    public int moveStoneMinTime(int[] stones, int H) {
        if (stones.length == 0) return 0;

        int len = stones.length;
        Arrays.sort(stones);
        int min = stones[0];
        int max = stones[len - 1];

        if (len == H) return max;

        int res = Integer.MAX_VALUE;
        for (int k = max; k >= 1; k--) {
            int tempH = 0;
            for (int j = 0; j < len; j++) {
                if (k >= stones[j]) tempH++;

                if (k < stones[j]) {
                    int count = stones[j] / k + 1;

                    tempH += count;
                }

                if (tempH == H && j == len - 1) {
                    if (k < res) res = k;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TestMain main = new TestMain();
        int[] stone = {3,6,7,11};
        int res = main.moveStoneMinTime(stone, 8);
        System.out.println(res);
    }
}
