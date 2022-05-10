package com.jianzhi.master3;

/**
 * https://leetcode.cn/problems/Gu0c2T/
 * 剑指 Offer II 089. 房屋偷盗
 */
public class Question89 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];

        // 1. dp[i] 表示偷至 i 间房屋时, 所偷得的最高金额
        int[] dp = new int[len];
        //2. dp数组初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 3. 遍历顺序, 从前向后
        for (int i = 2; i < len; i++) {
            // 4. 状态转移方程
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[len - 1];
    }
}
