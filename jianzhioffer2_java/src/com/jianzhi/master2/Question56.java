package com.jianzhi.master2;

import java.util.HashSet;

/**
 * HashSet + 中序遍历
 * 注意: 这种写法是遇到满足的条件就 及时返回
 *
 * https://leetcode-cn.com/problems/opLdQZ/
 * 剑指 Offer II 056. 二叉搜索树中两个节点之和
 */
public class Question56 {
    HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        if (findTarget(root.left, k)) return true;

        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);

        if (findTarget(root.right, k)) return true;

        return false;
    }
}
