package top.colorfo.dp;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; //1.确定dp数组，dp[i][j] 表示 (0,0) -> (i,j)一共有多少种路径

        //2.dp数组的初始化
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;

        //3.确定遍历顺序
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //4.确定递推表达式
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m-1][n-1];

    }
}
