package top.colorfo.backtrace;

import java.util.LinkedList;
import java.util.List;

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

    //=------------------=
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> permute = permutations.permute(new int[]{1, 2, 3});

        for(List<Integer> list : permute){
            System.out.println(list);
        }

    }
}
