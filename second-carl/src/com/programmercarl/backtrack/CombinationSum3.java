package com.programmercarl.backtrack;

import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */
public class CombinationSum3 {
    List<List<Integer>> result;
    List<Integer> paths;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        paths = new ArrayList<>();

        backtracking(k, n, 1, 0);

        return result;
    }

    //这里的参数pathSum主要是为了剪枝用的
    public void backtracking(int k, int n, int startIndex, int pathSum) {
        int sum = 0;
        if (paths.size() == k) {  //递归终止条件
            for (int number : paths) {
                sum += number;
            }
            if (sum == n) {
                result.add(new ArrayList(paths));
            }
            return;
        }

        // "(i + pathSum) <= n"这个判断语句 体现了 剪枝优化的过程
        for (int i = startIndex; i <= 9 && (i + pathSum) <= n; i++) {
            //处理节点
            pathSum += i;
            paths.add(i);

            //递归
            backtracking(k, n, i + 1, pathSum);

            //回溯
            pathSum -= i;
            paths.remove(paths.size() - 1);
        }
    }
}
