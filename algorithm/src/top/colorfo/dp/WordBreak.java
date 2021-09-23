package top.colorfo.dp;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/word-break/
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (wordDict.contains(s.substring(j,i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
