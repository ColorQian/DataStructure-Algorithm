package top.colorfo.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/subsets/
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例: 输入: nums = [1,2,3] 输出: [ [3], [1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
 *
 */
public class Subsets {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path  = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {

        if (nums.length == 0) return result;

        backtracking(nums,0);

        return result;

    }

    private void backtracking(int[] nums, int startIndex) {

        result.add(new LinkedList<>(path));  // 收集子集，要放在终止添加的上面，否则会漏掉自己
        if (startIndex >= nums.length) return;

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);

            backtracking(nums,i+1);

            path.removeLast();
        }
    }
}
