package top.colorfo.dpsubsequence;

/**
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 */
public class DeleteTwoStrings {
    public int minDistance(String word1, String word2) {
        //dp[i][j] 表示 使得以下标i-1结尾的word1 和 以j-1为结尾的word2 相同，所需要删除字符的最小个数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        //dp数组初始化
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
