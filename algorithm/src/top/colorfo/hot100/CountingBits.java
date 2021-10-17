package top.colorfo.hot100;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) { //如果是奇数，就比前面的偶数多了一个1
                result[i] = result[i - 1] + 1;
            } else {   //如果是偶数，就跟 i / 2 的1的个数相同(i右移一位，得到i/2)
                result[i] = result[i / 2];
            }
        }
        return result;
    }
}
