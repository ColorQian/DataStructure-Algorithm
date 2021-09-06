package top.colorfo.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例: 输入: [1,2,3] 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 *
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);

        return result;
    }

    private void backtracking(int[] nums) {

        if (nums.length == path.size()){
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            //通过判断path中是否存在数字，排除已经选择的数字
            if (path.contains(nums[i])){
                continue;
            }

            path.add(nums[i]);

            backtracking(nums);

            path.removeLast();
        }
    }
}
