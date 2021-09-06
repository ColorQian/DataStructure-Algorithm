package top.colorfo.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
 * 你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 * 输入: [4, 6, 7, 7] 输出:
 * [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 */
public class IncreasingSubsequences {

    /**
     * 备注：
     * 这种写法，输入[4,6,7,7],可以得到想要的输出，
     * 但是不能被LeetCode AC,原因不明
     */
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {

        backtracking(nums,0);

        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        if (path.size() >= 2) result.add(new LinkedList<>(path));

        if (startIndex >= nums.length) return;

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i-1]) continue;  //去重

            if (i == 0 || nums[i] >= nums[i-1]){ //针对
                path.add(nums[i]);

                backtracking(nums,i+1);

                path.removeLast();
            }else {
                //break;
                continue;
            }
        }
    }

    //----------------

    public static void main(String[] args) {
        IncreasingSubsequences subsequences = new IncreasingSubsequences();
        int[] nums = {4,6,7,7};
        List<List<Integer>> subsequences1 = subsequences.findSubsequences(nums);

        for (List<Integer> list : subsequences1) {
            System.out.println(list);
        }
    }
}
