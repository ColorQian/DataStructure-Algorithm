package com.jianzhi.master3;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/uUsW3B/
 * 剑指 Offer II 080. 含有 k 个元素的组合
 */
public class Question80 {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        path = new ArrayList<>();

        backtracking(n, 1, k);

        return result;
    }

    public void backtracking(int n, int index, int k) {
        if (path.size() == k) {
            result.add(new ArrayList(path));
            return;
        }

        for (int i = index; i <= n; i++) {
            path.add(i);

            backtracking(n, i + 1, k);

            path.remove(path.size() - 1);
        }
    }
}
