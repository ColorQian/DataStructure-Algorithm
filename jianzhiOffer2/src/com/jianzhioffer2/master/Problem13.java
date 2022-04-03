package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * 机器人的运动范围
 * (这题我不太理解为什么要递归？？？)
 */
public class Problem13 {
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return dfs(0, 0, m, n, k);
    }

    private int dfs(int i, int j, int m, int n, int k) {
        if (i >= m || j >= n || getSum(i) + getSum(j) > k || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        return 1 + dfs(i + 1, j, m, n, k) + dfs(i, j + 1, m, n, k);
    }

    private int getSum(int a) {
        if (a < 10) return a;

        int sum = 0;
        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

}
