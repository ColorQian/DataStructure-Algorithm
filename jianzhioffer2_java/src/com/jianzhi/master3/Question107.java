package com.jianzhi.master3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/2bCMpM/
 * 剑指 Offer II 107. 矩阵中的距离
 *
 * 参考题解: https://leetcode.cn/problems/01-matrix/solution/2chong-bfs-xiang-jie-dp-bi-xu-miao-dong-by-sweetie/
 */
public class Question107 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int curX = x + dx[i];
                int curY = y + dy[i];

                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 mat[x][y] + 1
                if (curX >= 0 && curX < m && curY >= 0 && curY < n && mat[curX][curY] == -1) {
                    mat[curX][curY] = mat[x][y] + 1;
                    queue.offer(new int[]{curX, curY});
                }
            }
        }
        return mat;
    }
}
