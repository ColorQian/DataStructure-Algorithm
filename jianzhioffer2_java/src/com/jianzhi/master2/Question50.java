package com.jianzhi.master2;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/6eUYwP/
 * 剑指 Offer II 050. 向下的路径节点之和
 */
public class Question50 {
    HashMap<Integer, Integer> map;
    int sum;
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        sum = targetSum;
        map.put(0, 1);        // 这一步很关键;

        int count = dfs(root, 0);

        return count;
    }

    private int dfs(TreeNode root, int path) {
        if (root == null) return 0;

        path += root.val;
        int count = map.getOrDefault(path - sum, 0);  // 看是否有这样的前缀和
        map.put(path, map.getOrDefault(path, 0) + 1); // 更新前缀和

        count += dfs(root.left, path);
        count += dfs(root.right, path);

        map.put(path, map.get(path) - 1); // 回溯

        return count;
    }
}
