package top.colorfo.dpsubsequence;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        //dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]。
        int[][] dp = new int[s.length()][s.length()];
        //dp数组初始化
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        //注意遍历顺序和递推公式
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
