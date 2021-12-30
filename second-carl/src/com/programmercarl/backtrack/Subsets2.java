package com.programmercarl.backtrack;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 * 给你一个整数数组 nums ，其中可能包含重复元素，
 * 请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集
 */
public class Subsets2 {
    List<Integer> path;
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    /**
     *注意：本题在去重之前，一定要先对nums排序，不然有些测试用例通过不了例如:[4,4,4,1,4]
     * 即去重操作：if (i > startIndex && nums[i] == nums[i - 1]) continue;
     * 与排序操作：Arrays.sort(nums); 要配合使用
     */
    public void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList(path));

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) continue;//去重
            path.add(nums[i]);

            backtracking(nums, i + 1);

            path.remove(path.size() - 1);
        }
    }
}
