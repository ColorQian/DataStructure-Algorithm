package top.colorfo.dp;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length]; //dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]。

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            //决定dp[i] 的因素就是 第i房间 偷还是不偷
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
