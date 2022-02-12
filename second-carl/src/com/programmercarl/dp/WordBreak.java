package com.programmercarl.dp;

import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/word-break/
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        //dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
        boolean[] dp = new boolean[s.length()+ 1];
        dp[0] = true;

        //先遍历背包，再遍历物品
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i <= j; i++) {        //这里的物品，其实就是截取的一个个子串
                if (wordSet.contains(s.substring(i, j)) && dp[i]) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
