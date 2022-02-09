package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 不同的二叉搜索树
 */
public class UniqueBST {
    public int numTrees(int n) {
        if (n <= 2) return n;

        //dp[i] : 1到i为节点组成的二叉搜索树的个数为dp[i]。
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
