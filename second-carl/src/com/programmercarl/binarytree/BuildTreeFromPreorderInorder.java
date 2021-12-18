package com.programmercarl.binarytree;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 从前序与中序遍历序列构造二叉树
 */
public class BuildTreeFromPreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        return traversal(inorder, 0, inorder.length,
                preorder, 0, preorder.length);  //左闭右开
    }

    private TreeNode traversal(int[] inorder, int inLeft, int inRight,
                               int[] preorder, int preLeft, int preRight) {

        if (preLeft == preRight) return null;  //递归终止条件

        //构造根节点
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);

        //叶子节点
        if (preRight - preLeft == 1) return root;

        //找前序遍历数组的第一个值 在 中序遍历数组的下标
        int rootIndex;
        for (rootIndex = 0; rootIndex < inorder.length; rootIndex++) {
            if (inorder[rootIndex] == rootValue) break;
        }

        /**
         * 递归遍历构造左右子树
         */
        //1.首先根据rootIndex切割中序数组 切割为 中序左数组 和 中序右数组
        root.left = traversal(inorder, inLeft, rootIndex,
                preorder, preLeft + 1, preLeft + 1 + (rootIndex - inLeft)); //preLeft + 1:舍弃第一个元素，因为这个元素就是中间节点，已经用过了
        //2.其次根据中序左数组 和 右数组的长度， 再来切割前序数组
        //因为：中序数组大小一定是和前序数组的大小相同的
        root.right = traversal(inorder, rootIndex + 1, inRight,
                preorder, preRight - (inRight - rootIndex - 1), preRight);

        return root;
    }
}
