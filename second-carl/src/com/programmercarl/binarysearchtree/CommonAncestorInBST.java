package com.programmercarl.binarysearchtree;


public class CommonAncestorInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;

        if (root.val < p.val && root.val < q.val) { //向右子树递归查找
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val  > p.val && root.val > q.val) { //向左子树递归查找
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;     //找到则返回
        }
    }
}
