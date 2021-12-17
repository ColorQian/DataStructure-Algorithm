package com.programmercarl.binarytree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, result, targetSum);
        return result;
    }

    void traversal(TreeNode cur, List<Integer> paths, List<List<Integer>> result, int targetSum) {
        paths.add(cur.val);

        if (cur.left == null && cur.right == null) {
            int sum = 0;
            for (int nodeVal : paths) {
                sum += nodeVal;
            }
            if (sum == targetSum) result.add(new ArrayList(paths)); //此处注意,不能result.add(paths)
        }

        if (cur.left != null) {
            traversal(cur.left, paths, result, targetSum);  //递归
            paths.remove(paths.size() - 1);      //回溯

        }

        if (cur.right != null) {
            traversal(cur.right, paths, result, targetSum);  //递归
            paths.remove(paths.size() - 1);       //回溯
        }
    }
}
