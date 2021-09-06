package top.colorfo.backtrace;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 示例 1: 输入: candidates = [10,1,2,7,6,1,5], target = 8, 所求解集为:
 * [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 *
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 */
public class CombinationNoRepeatSum {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        backtracking(candidates,target,0);

        return result;
    }

    private void backtracking(int[] candidates, int target, int startIndex) {

        if (sum == target){
            result.add(new LinkedList<>(path));
            return;
        }else if (sum > target) return;

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {//sum + candidates[i] <= target为剪枝操作
            // 要对同一树层使用过的元素进行跳过,是一个去重操作
            if (i > startIndex && candidates[i] == candidates[i-1]){
                continue;
            }

            path.add(candidates[i]);
            sum += candidates[i];

            backtracking(candidates,target,i + 1);

            path.removeLast();
            sum -= candidates[i];
        }
    }

    //------------------------
    public static void main(String[] args) {
        CombinationNoRepeatSum combination = new CombinationNoRepeatSum();
        int[] cadidates = {2,5,2,1,2};
        combination.combinationSum2(cadidates,5);
    }
}
