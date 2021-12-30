package com.programmercarl.backtrack;

import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）
 */
public class Subsets {
    List<Integer> path;
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        path = new ArrayList<>();
        result = new ArrayList<>();

        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList(path)); //收集结果

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);  //处理节点

            backtracking(nums, i + 1); //递归

            path.remove(path.size() - 1);  //回溯
        }
    }
}
