package top.colorfo.dp;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class HouseRobber2 {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int result1 = robRange(0, nums.length - 2, nums);  //考虑抢劫第一家，最后一家放弃
        int result2 = robRange(1, nums.length - 1, nums);  //考虑抢劫最后一家，第一家放弃

        return Math.max(result1, result2);
    }

    //普通的打家劫舍逻辑
    private int robRange(int start, int end, int[] nums) {
        if (start == end) return nums[start];

        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start + 1], nums[start]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
