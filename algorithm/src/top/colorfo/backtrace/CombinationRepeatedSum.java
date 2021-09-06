package top.colorfo.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 *给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 *示例 2： 输入：candidates = [2,3,5], target = 8, 所求解集为： [[2,2,2,2],[2,3,3],[3,5]]
 *
 * 链接：https://leetcode-cn.com/problems/combination-sum
 */
public class CombinationRepeatedSum {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return result;

        backtracking(candidates,target,0);

        return result;
    }

    private void backtracking(int[] candidates, int target,int startIndex) {
        if (sum == target){
            result.add(new LinkedList<>(path));
            return;
        }else if (sum > target) return;

        for (int i = startIndex; i < candidates.length; i++) {

            if (sum + candidates[i] > target) continue; //剪枝优化

            path.add(candidates[i]);
            sum += candidates[i];

            backtracking(candidates,target,i); //注意这里是 i

            //回溯
            path.removeLast();
            sum -= candidates[i];
        }

    }

    //=================

    public static void main(String[] args) {
        CombinationRepeatedSum combination = new CombinationRepeatedSum();

        int[] cadidates = {2,3,5};
        combination.combinationSum(cadidates,8);
    }

}
