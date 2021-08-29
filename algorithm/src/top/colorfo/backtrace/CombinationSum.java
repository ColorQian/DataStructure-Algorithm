package top.colorfo.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
 * 并且每种组合中不存在重复的数字。
 *
 * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
 * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum;
    public List<List<Integer>> combinationSum3(int k, int n) {

        combination(k,n,1);

        return result;
    }

    private void combination(int k, int targetSum, int startIndex) {
        if (path.size() == k){
            if (targetSum == sum){
                result.add(new LinkedList<>(path));
            }
            return;  //如果path.size() == k 但sum != targetSum 直接返回
        }

        if (sum > targetSum) return;

        for (int i = startIndex; i <= 9-(k-path.size())+1; i++) {
            path.add(i);
            sum += i;

            combination(k,targetSum,i+1);  // 注意i+1调整startIndex

            path.removeLast(); //回溯
            sum -= i;

        }
    }
}
