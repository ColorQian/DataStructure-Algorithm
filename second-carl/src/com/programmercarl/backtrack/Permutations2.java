package com.programmercarl.backtrack;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
 */
public class Permutations2 {
    List<Integer> path;
    List<List<Integer>> result;
    int[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        used = new int[nums.length]; //used[]数组用来标记已经使用过的数组元素
        //used[i] == 1 -> nums中的nums[i]元素已经被使用

        Arrays.sort(nums);      //去重前一定得排序！！！
        backtracking(nums, 0);

        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return;
        }

        //注意 排列对比组合问题，for循环的起始位置 以及 递归下一层时参数startIndex的值
        for (int i = 0; i < nums.length; i++) {  //注意for循环的起始位置 i = 0
            // used[i - 1] == 0，说明同一树层nums[i - 1]使用过(同一树层指的是横向for循环)
            // 如果同一树层nums[i - 1]使用过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) continue;

            if (used[i] == 0) {
                path.add(nums[i]); //处理当前元素
                used[i] = 1;

                backtracking(nums, i + 1);  //递归,注意从i + 1

                path.remove(path.size() - 1); //回溯
                used[i] = 0;
            }
        }
    }
}
