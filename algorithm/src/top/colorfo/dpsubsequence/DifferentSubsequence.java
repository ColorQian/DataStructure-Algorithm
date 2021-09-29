package top.colorfo.dpsubsequence;

/**
 * https://leetcode-cn.com/problems/distinct-subsequences/
 */
public class DifferentSubsequence {
    public int numDistinct(String s, String t) {
        //dp[i][j] 表示下标为i-1的s 包含 下标为j-1的t 的个数
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        //初始化dp数组
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
