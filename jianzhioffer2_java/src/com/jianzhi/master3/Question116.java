package com.jianzhi.master3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/bLyHh0/
 * 剑指 Offer II 116. 省份数量
 */
public class Question116 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {  // 如果当前省份没被访问过
                // 找出与其相连的所有城市, 标记为访问过
                findConnected(isConnected, isVisited, i);
                // 所有的城市构成一个省份, 将省份数量+1
                result++;
            }
        }
        return result;
    }

    public void findConnected(int[][] isConnected, boolean[] isVisited, int city) {
        // 使用广度优先遍历, 搜索省份对应的所有城市
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(city);
        isVisited[city] = true; // 将当前城市标记为访问过

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 找出与当前城市相连的所有城市, 并标记为访问过
            int[] citys = isConnected[cur];
            for (int i = 0; i < citys.length; i++) {
                if (citys[i] == 1 && !isVisited[i]) {
                    queue.offer(i);
                    isVisited[i] = true;
                }
            }
        }
    }
}
