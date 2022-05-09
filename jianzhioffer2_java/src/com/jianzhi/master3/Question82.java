package com.jianzhi.master3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/4sjJUc/
 * 剑指 Offer II 082. 含有重复元素集合的组合
 */
public class Question82 {
    List<List<Integer>> result;
    List<Integer> path;
    int tempSum;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        tempSum = 0;

        Arrays.sort(candidates);
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
            // 注意这里的条件 i > startIndex(而不是i > 0)
            if (i > startIndex && candidates[i] == candidates[i - 1]) continue;

            tempSum += candidates[i];
            path.add(candidates[i]);

            backtracking(candidates, i + 1, target);

            tempSum -= candidates[i];
            path.remove(path.size() - 1);
        }

    }
}
