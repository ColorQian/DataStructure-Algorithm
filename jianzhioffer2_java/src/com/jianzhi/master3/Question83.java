package com.jianzhi.master3;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/VvJkup/
 * 剑指 Offer II 083. 没有重复元素集合的全排列
 */
public class Question83 {
    List<List<Integer>> result;
    List<Integer> path;
    int[] used;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        used = new int[nums.length];

        backtracking(nums);

        return result;
    }

    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;

            path.add(nums[i]);
            used[i] = 1;

            backtracking(nums);

            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
