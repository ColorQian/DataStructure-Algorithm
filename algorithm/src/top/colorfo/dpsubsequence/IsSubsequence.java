package top.colorfo.dpsubsequence;

/**
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        int n1 = s.length();
        int n2 = t.length();
        //dp[i][j] 表示 如果长度为i的s 是 长度为j的t的子串 , 则dp[i][j] == s.length
        int[][] dp = new int[n1 + 1][n2 + 1];

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2 ; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {  //此时相当于t要删除元素，t如果把当前元素t[j - 1]删除，那么dp[i][j] 的数值就是 看s[i - 1]与 t[j - 2]的比较结果了，即：dp[i][j] = dp[i][j - 1];
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n1][n2] == s.length();
    }
}
