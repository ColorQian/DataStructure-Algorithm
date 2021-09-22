package top.colorfo.dp;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class UniqueBST {

    public static int numTrees(int n) {
        int[] dp = new int[n+1];   // 1到i为节点组成的二叉搜索树的个数为dp[i]。

        dp[0] = 1;     //初始化，空节点也是一颗二叉树
        for (int i = 1; i <= n; i++) {
            //j-1 为j为头结点左子树节点数量，i-j 为以j为头结点右子树节点数量
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
