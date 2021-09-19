package top.colorfo.dp;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class FibonacciNumber {

    public int fib(int n) {
        if (n <= 1) return n;

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }

        return sum;  //return dp[1]也可以
    }
}
