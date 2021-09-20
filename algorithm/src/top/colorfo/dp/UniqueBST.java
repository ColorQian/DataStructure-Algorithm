package top.colorfo.dp;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class UniqueBST {

    public static int numTrees(int n) {
        int[] dp = new int[n+1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    //---------------
    public static void main(String[] args) {
        int i = numTrees(3);
        System.out.println(i);
    }
}
