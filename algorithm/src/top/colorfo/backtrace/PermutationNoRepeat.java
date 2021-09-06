package top.colorfo.backtrace;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1： 输入：nums = [1,1,2] 输出： [[1,1,2], [1,2,1], [2,1,1]]
 * 示例 2： 输入：nums = [1,2,3] 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class PermutationNoRepeat {

    List<List<Integer>> result = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {

        used = new boolean[nums.length];
        Arrays.sort(nums);

        backtracking(nums);

        return result;
    }

    private void backtracking(int[] nums) {

        if (path.size() == nums.length) {
            result.add(new LinkedList(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // used[i - 1] == false，说明同一树层nums[i - 1]使用过
            // 如果同一树层nums[i - 1]使用过则直接跳过
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false){
                continue;
            }

            if (used[i] == false){
                path.add(nums[i]);
                used[i] = true;

                backtracking(nums);

                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
