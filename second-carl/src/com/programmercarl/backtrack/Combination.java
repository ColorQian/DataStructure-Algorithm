package com.programmercarl.backtrack;

import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/combinations/
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 */
public class Combination {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(n, k, 1);

        return result;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {   //递归终止条件
            result.add(new ArrayList(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {  //横向遍历，相当于树的宽度
            //剪枝优化写法:for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) { }
            path.add(i);  //处理节点
            backtracking(n, k, i + 1); //递归，往树的深度走
            path.remove(path.size() - 1);  //回溯
        }
    }


}
