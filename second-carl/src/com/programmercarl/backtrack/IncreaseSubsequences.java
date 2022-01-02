package com.programmercarl.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/increasing-subsequences/
 *
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * 示例:
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 * 说明:
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况
 */
public class IncreaseSubsequences {
    List<Integer> path;
    List<List<Integer>> result;
    public List<List<Integer>> findSubsequences(int[] nums) {
        path = new ArrayList<>();
        result = new ArrayList<>();

        backtracking(nums, 0);

        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        if (path.size() > 1) {
            result.add(new ArrayList(path));
        }

        int[] used = new int[201]; //用来标记已经使用过的数，起到去重效果,因为下标从0开始，受nums[i]范围所限，所以+100
                                    //(used[nums[i] + 100] == 1,used[]下标对应nums[i],1表示本层已经使用过)
        for (int i = startIndex; i < nums.length; i++) {

            if ((path.size() != 0 && nums[i] < path.get(path.size() - 1)) || used[nums[i] + 100] == 1) {
                continue;       //不是递增的子序列 或者 本层已经使用过了 直接 跳过本次循环
            }
            used[nums[i] + 100] = 1;  //修改used数组
            path.add(nums[i]);

            backtracking(nums, i + 1);

            path.remove(path.size() - 1);
        }
    }
}
