package com.programmercarl.binarytree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * 判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum。
 */
public class PathSum {
    /**
     *方法一：将所有的路径都保存，然后判断是否存在路径和 == targetSum的情况
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        List<Integer> paths = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        traversal(root, paths, result);
        for (int sum : result) {
            if (sum == targetSum) return true;
        }
        return false;
    }
    //paths保存递归过程中的路径节点，result保存每一条路径上节点值的和
    void traversal(TreeNode cur, List<Integer> paths, List<Integer> result) {

        paths.add(cur.val);

        if (cur.left == null && cur.right == null) {
            int sum = 0;
            for (int nodeVal : paths) {
                sum += nodeVal;
            }
            result.add(sum);
        }

        if (cur.left != null) {
            traversal(cur.left, paths, result); //递归
            paths.remove(paths.size() - 1);     //回溯
        }

        if (cur.right != null) {
            traversal(cur.right, paths, result); //递归
            paths.remove(paths.size() - 1);      //回溯
        }
        new ArrayList<>(paths);
    }
}
