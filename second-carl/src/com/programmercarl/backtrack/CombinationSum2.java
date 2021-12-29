package com.programmercarl.backtrack;

import java.util.*;

public class CombinationSum2 {
    List<Integer> path;
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        path = new ArrayList<>();
        result = new ArrayList<>();

        Arrays.sort(candidates);  //排序
        backtracking(candidates, target, 0, 0);

        return result;
    }

    public void backtracking(int[] candidates, int target, int index, int sum) {
        //if (sum > target) return;

        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }

        //(candidates[i] + sum <= target)->剪枝操作
        for (int i = index; i < candidates.length && (candidates[i] + sum <= target); i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;  //去重

            //处理节点
            sum += candidates[i];
            path.add(candidates[i]);

            //递归
            backtracking(candidates, target, i + 1, sum);  //注意此处的参数index:千万不要写成index + 1

            //回溯
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
