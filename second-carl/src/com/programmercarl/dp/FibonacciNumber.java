package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class FibonacciNumber {
    public int fib(int n) {
        if (n <= 1) return n;

        int[] fibArray = new int[n + 1];   //1.下标表示第n项,fibArray[n] 对应于 F(n)
        fibArray[0] = 0;   //2.dp数组初始化
        fibArray[1] = 1;

        //3.确定遍历顺序
        for (int i = 2; i <= n; i++) {
            //4.确定递推公式
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray[n];
    }
}
