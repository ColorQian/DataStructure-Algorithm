package com.programmercarl.binarytree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 找出从根节点到叶子节点的所有路径
 */
public class PathsOfBT {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, result);
        return result;
    }

    /**
     * 该方法使用了递归加回溯
     */
    //使用了前序遍历的方式(亦满足递归三部曲)
    void traversal(TreeNode cur, List<Integer> paths, List<String> result) {
        paths.add(cur.val);     //中
        //遇到叶子节点，把paths保存的节点 转换为 字符串路径
        if (cur.left == null && cur.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i));
                sb.append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            result.add(sb.toString());
        }

        if (cur.left != null) {    //左
            traversal(cur.left, paths, result);  //递归
            paths.remove(paths.size() - 1);   //回溯
        }

        if (cur.right != null) {    //右
            traversal(cur.right, paths, result);  //递归
            paths.remove(paths.size() - 1);   //回溯
        }
    }
}
