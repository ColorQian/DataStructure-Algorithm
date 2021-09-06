package top.colorfo.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合问题，返回[1,n]，中所有的k个数的组合
 */
public class Combine {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }

    private void combineHelper(int n, int k, int startIndex){
        //终止条件
        if (path.size() == k){
            result.add(new LinkedList(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){  //剪枝优化
            path.add(i);
            combineHelper(n, k, i + 1);
            path.removeLast();   //回溯
        }
    }
}


