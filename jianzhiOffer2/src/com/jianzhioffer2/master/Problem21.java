package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/submissions/
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class Problem21 {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        if (len == 0) return new int[0];

        // 标记奇数和偶数
        int[] flag = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 1) {
                flag[i] = 1;
            }
        }

        // 先放奇数
        int[] res = new int[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (flag[i] == 1) {
                res[count++] = nums[i];
            }
        }

        // 再放偶数
        for (int i = 0; i < len; i++) {
            if (flag[i] == 0) {
                res[count++] = nums[i];
            }
        }
        return res;
    }
}
