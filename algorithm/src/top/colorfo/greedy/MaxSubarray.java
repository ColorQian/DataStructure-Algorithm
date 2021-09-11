package top.colorfo.greedy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例: 输入: [-2,1,-3,4,-1,2,1,-5,4] 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 *
 * https://leetcode-cn.com/problems/maximum-subarray/submissions/
 */
public class MaxSubarray {

    /**
     * 暴力解法，时间复杂度O(n^2)
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                result = count > result ? count : result;
            }
        }
        return result;
    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums){

        int result = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i];

            // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count <= 0) count = 0;

            // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            if (count > result) result = count;
        }
        return result;
    }
}
