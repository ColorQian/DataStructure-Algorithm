package com.programmercarl.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permutation {
    List<Integer> path;
    List<List<Integer>> result;
    int[] used;
    public List<List<Integer>> permute(int[] nums) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        used = new int[nums.length]; //used[] 数组用来标记已经使用过的数组
        //used[i] == 1 -> nums中的nums[i]元素已经被使用

        backtracking(nums, 0);

        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return;
        }

        //注意 组合对比排列问题，for循环的起始位置 以及 递归下一层时参数startIndex的值
        for (int i = 0; i < nums.length; i++) {  //注意for循环的起始位置 i = 0
            if (used[i] == 1) continue;  //跳过使用过的元素

            path.add(nums[i]); //处理当前元素
            used[i] = 1;

            backtracking(nums, i + 1);  //递归,注意从i + 1

            path.remove(path.size() - 1); //回溯
            used[i] = 0;
        }

    }
}
