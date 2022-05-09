package com.jianzhi.master3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/7p8L0Z/
 * 剑指 Offer II 084. 含有重复元素集合的全排列
 */
public class Question84 {
    List<List<Integer>> result;
    List<Integer> path;
    int[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        used = new int[nums.length];

        Arrays.sort(nums);   // *****记得排序!!!*****
        backtracking(nums);

        return result;
    }

    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 已经使用过的不再使用
            if (used[i] == 1) continue;
            // 候选数组中有重复的元素, 下面的一行语句, 可以避免重复的排列出现
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) continue;

            path.add(nums[i]);
            used[i] = 1;

            backtracking(nums);

            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
