package com.programmercarl.binarytree;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 合并两颗二叉树
 */
public class MergeTwoBTs {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        else if (root1 == null && root2 != null) return root2;
        else if (root1 != null && root2 == null) return root1;
        else if (root1 != null && root2 != null){
            root1.val += root2.val;
            //这里不能写:return root1;
            //因为还没递归遍历root1的左右子树
        }

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

}
