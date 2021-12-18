package com.programmercarl.binarytree;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 根据一棵树的中序遍历和后序遍历，构造二叉树
 */
public class BuildTreeFromInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;

        return traversal(inorder, 0, inorder.length,
                postorder, 0, postorder.length);  //左闭右开
    }

    private TreeNode traversal(int[] inorder,int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {

        if (postLeft == postRight) return null; //递归终止条件

        //以后序遍历的最后一个元素，构造根节点
        int rootValue = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootValue);

        //叶子节点
        if (postRight - postLeft == 1) return root;

        //1.找到后序遍历的最后一个元素，在中序遍历数组中的下标
        int delimiterIndex;
        for (delimiterIndex = 0; delimiterIndex < inorder.length; delimiterIndex++) {
            if (inorder[delimiterIndex] == rootValue) break; //说明找到，终止循环
        }

        //2.根据delimiterIndex划分左右子树
        //2.1首先根据delimiterIndex切割 中序左数组，再根据中序左数组的长度，切割后序左数组
        root.left = traversal(inorder, inLeft, delimiterIndex,
                postorder, postLeft, postLeft + (delimiterIndex - inLeft));
        //2.2其次 根据delimiterIndex切割 中序右数组，再根据中序右数组的长度，切割后序右数组
        root.right = traversal(inorder, delimiterIndex + 1, inRight,
                postorder, postRight - 1 - (inRight  - delimiterIndex - 1), postRight - 1);

        return root;
    }
}
