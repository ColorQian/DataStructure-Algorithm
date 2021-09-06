package top.colorfo.backtrace;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test16 {

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
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            //去重操作
            if (i > 0 && nums[i] == nums[i - 1] && used[i-1] == false) {
                continue;
            }

            if (used[i] == false) {
                path.add(nums[i]);
                used[i] = true;

                backtracking(nums);

                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
