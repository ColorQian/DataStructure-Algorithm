package top.colorfo.dp;

/**
 * 改为：一步一个台阶，两个台阶，三个台阶，.......，直到 m个台阶。
 * 问有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbingStairs2 {

    public int climStairs(int n, int m) { //n表示一共有n个台阶，m表示一次最多可以跳m步
        int[] dp = new int[n + 1];
        dp[0] = 1;

        //完全背包中的排列问题
        for (int j = 1; j <= n; j++) {   //先遍历背包
            for (int i = 1; i <= m; i++) {  //再遍历物品
                if (j >= i) dp[j] += dp[j - i];
            }
        }

        return dp[n];
    }
}
