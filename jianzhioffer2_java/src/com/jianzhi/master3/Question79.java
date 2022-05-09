package com.jianzhi.master3;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/TVdhkn/
 * 剑指 Offer II 079. 所有子集
 */
public class Question79 {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();

        dfs(nums, 0);

        return result;
    }

    public void dfs(int[] nums, int index) {
        result.add(new ArrayList(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);   // 处理节点

            dfs(nums, i + 1);    // 递归

            path.remove(path.size() - 1);  // 回溯
        }
    }
}
