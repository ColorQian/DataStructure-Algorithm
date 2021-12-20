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
        root.left = traversal(inorder, inLeft, delimiterIndex, //切割中序左数组
                postorder, postLeft, postLeft + (delimiterIndex - inLeft)); //切割后序左数组

        root.right = traversal(inorder, delimiterIndex + 1, inRight, //切割中序右数组
                postorder, postRight - 1 - (inRight  - delimiterIndex - 1), postRight - 1);//切割后序右数组

        return root;
    }
}
