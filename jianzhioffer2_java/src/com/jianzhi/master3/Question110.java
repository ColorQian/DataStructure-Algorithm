package com.jianzhi.master3;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/bP4bmD/
 * 剑指 Offer II 110. 所有路径
 */
public class Question110 {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new LinkedList<>();
        path = new LinkedList<>();

        dfs(0, graph);

        return result;
    }

    public void dfs(int source, int[][] graph) {
        path.add(source);

        if (source == graph.length - 1) {
            result.add(new LinkedList(path));
        } else {
            for (int next : graph[source]) {
                dfs(next, graph);
            }
        }

        path.remove(path.size() - 1);
    }
}
