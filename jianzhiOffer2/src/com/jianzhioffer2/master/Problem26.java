package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 剑指 Offer 26. 树的子结构
 *
 * 注意与下面这题进行比较：
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 572. 另一棵树的子树
 */
public class Problem26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {   // B树是A的一部分，允许缺失
            return true;
        }
        if (A == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
