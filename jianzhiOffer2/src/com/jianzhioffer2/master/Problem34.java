package com.jianzhioffer2.master;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * 找出二叉树中所有的 和为某一值的路径
 */
public class Problem34 {
    int sum;
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        sum = target;
        result = new ArrayList<>();
        path = new ArrayList<>();
        if (root == null) return result;
        backtracking(root);
        return result;
    }

    private void backtracking(TreeNode root) {
        sum -= root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == 0) {
                result.add(new ArrayList(path));
            }
            return;
        }

        if (root.left != null) {
            backtracking(root.left);  // 递归

            sum += root.left.val;     // 回溯
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            backtracking(root.right);  // 递归

            sum += root.right.val;     // 回溯
            path.remove(path.size() - 1);
        }
    }
}
