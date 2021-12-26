package com.programmercarl.binarysearchtree;

public class SortArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = constructTree(nums, 0, nums.length); //左闭右开
        return root;
    }

    //递归三部曲+双指针
    public TreeNode constructTree(int[] nums, int left, int right) {
        if (left == right) return null; //递归终止条件

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]); //构造根节点
        if (right - left == 1) return root;  //叶子节点

        root.left = constructTree(nums, left, mid); //构造左子节点
        root.right = constructTree(nums, mid + 1, right);  //递归构造右子节点

        return root;
    }
}
