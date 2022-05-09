package com.jianzhi.master3;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/Ygoe9J/
 * 剑指 Offer II 081. 允许重复选择元素的组合
 */
public class Question81 {
    List<List<Integer>> result;
    List<Integer> path;
    int tempSum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        tempSum = 0;

        backtracking(candidates, 0, target);

        return result;
    }

    public void backtracking(int[] candidates, int startIndex, int target) {
        if (tempSum > target) return;

        if (tempSum == target) {
            result.add(new ArrayList(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            tempSum += candidates[i];
            path.add(candidates[i]);

            backtracking(candidates, i, target);

            tempSum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
