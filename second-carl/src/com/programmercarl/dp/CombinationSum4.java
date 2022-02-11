package com.programmercarl.dp;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/combination-sum-iv/
 */
public class CombinationSum4 {
    /**
     * 方法一：使用回溯
     * leetcode提交会超时
     */
    List<Integer> path;
    int result;
    public int combinationSum4(int[] nums, int target) {
        path = new ArrayList<>();
        result = 0;

        int sum = 0;
        Arrays.sort(nums);
        backtracking(nums, target, sum);
        return result;
    }
    public void backtracking(int[] nums, int target, int sum) {
        if (sum == target) {
            result++;
            return;
        }

        // nums[i] + sum <= target 是一个剪枝操作
        for (int i = 0; i < nums.length && nums[i] + sum <= target; i++) {
            sum += nums[i];   //处理节点
            path.add(nums[i]);

            backtracking(nums, target, sum);  //递归

            sum -= nums[i];   //回溯
            path.remove(path.size() - 1);
        }
    }

    //----------------------------------
    //使用完全背包，解决排列总和问题
    public int combinationSum4_2(int[] nums, int target) {
        //装满容量为j的背包，共有dp[j]中排列方法
        int[] dp = new int[target + 1];

        dp[0] = 1;

        //先遍历背包容量，再遍历物品，遍历物品从小到大
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
