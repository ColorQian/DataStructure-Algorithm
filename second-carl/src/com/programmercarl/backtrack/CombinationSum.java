package com.programmercarl.backtrack;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 */
public class CombinationSum {
    List<Integer> path;
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        path = new ArrayList<>();
        result = new ArrayList<>();

        Arrays.sort(candidates); //排序
        backtracking(candidates, target, 0, 0);

        return result;
    }

    public void backtracking(int[] candidates, int target, int index, int sum) {
        if (sum > target) return;

        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }

        /**
         * 对数组排序之后，如果下一层的sum(就是本层的 sum + candidates[i])
         * 已经大于target，就可以结束本轮for循环的遍历。
         * 也就是说不满足条件：(candidates[i] + sum) <= target，
         * candidates[i]后面的元素肯定也不满足(因为已经排序了)，所以结束本层for循环
         *
         * 注意：
         * 这也就意味着
         *剪枝操作：(candidates[i] + sum) <= target
         * 要和数组排序：Arrays.sort(candidates);同时使用
         */
        for (int i = index; i < candidates.length && (candidates[i] + sum) <= target; i++) {
            sum += candidates[i];  //处理节点
            path.add(candidates[i]);

            backtracking(candidates, target, i, sum); //递归

            sum -= candidates[i];  //回溯
            path.remove(path.size() - 1);
        }
    }
}
