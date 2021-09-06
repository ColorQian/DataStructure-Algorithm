package top.colorfo.backtrace;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目链接：https://leetcode-cn.com/problems/subsets-ii/
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例: 输入: [1,2,2] 输出: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 *
 */
public class SubsetsNoRepeat {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  //先给nums数组排序

        backtracking(nums,0);

        return result;
    }

    private void backtracking(int[] nums, int startIndex) {

        result.add(new LinkedList<>(path)); // 收集子集，要放在终止条件的上面，否则会漏掉自己

        if (startIndex >= nums.length) return;  //终止条件

        for (int i = startIndex; i < nums.length; i++) {

            if (i > startIndex && nums[i] == nums[i-1]){ //去重操作(结果节不能有重复元素，要去重)
                continue;
            }

            path.add(nums[i]);

            backtracking(nums,i+1); //递归

            path.removeLast();  //回溯
        }
    }
}
