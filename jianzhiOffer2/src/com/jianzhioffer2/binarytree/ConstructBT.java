package com.jianzhioffer2.binarytree;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * 根据前序遍历和中序遍历重建二叉树
 */
public class ConstructBT {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        return traversal(preorder, 0, preorder.length,
                inorder, 0, inorder.length);
    }

    public TreeNode traversal(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft >= preRight) return null;

        if (preRight - preLeft == 1) return new TreeNode(preorder[preLeft]);  // 叶子节点

        int midValue = preorder[preLeft];
        int IndexIn = inLeft;
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == midValue) IndexIn = i;
        }

        TreeNode root = new TreeNode(midValue);

        root.left = traversal(preorder, preLeft + 1, preLeft + 1 + IndexIn - inLeft,
                inorder, inLeft, IndexIn);
        root.right = traversal(preorder, preRight - (inRight - IndexIn - 1), preRight,
                inorder, IndexIn + 1, inRight);

        return root;
    }
}
