package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        //dp[i] 表示偷到 下标为i 的房屋时的 最大收获金额为dp[i]
        int[] dp = new int[nums.length];

        //dp数组初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //遍历顺序从前向后
        for (int i = 2; i < nums.length; i++) {
            //确定递推公式
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
