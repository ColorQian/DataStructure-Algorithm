package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class EditDistance {
    /**
     * 此题中，插入 等价于 删除
     * 所以只需要考虑 删除 和 替换 两种操作即可
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        //以下标i-1为结尾的word1, 以下标就j-1为结尾的word2,想要达到相同,需要的编辑距离为dp[i][j]
        int[][] dp = new int[len1 + 1][len2 + 1];

        //dp[]数组初始化
        for (int i = 1; i <= len1; i++) dp[i][0] = i;
        for (int j = 1; j <= len2; j++) dp[0][j] = j;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,   //替换字符串
                            Math.min(dp[i - 1][j], dp[i][j - 1]) + 1); //删除字符串
                }
            }
        }
        return dp[len1][len2];
    }
}
