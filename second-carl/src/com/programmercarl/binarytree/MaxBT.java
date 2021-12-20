package com.programmercarl.binarytree;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * 以一个数组构造一个最大值二叉树
 */
public class MaxBT {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums, 0, nums.length);  //左闭右开
    }

    TreeNode traversal(int[] nums, int left, int right) { //1.返回值和函数参数
        if (left == right) return null;  //2.递归终止条件

        //3.单层遍历逻辑
        int maxValue = -1;
        int maxValueIndex = -1;
        for (int i = left; i < right; i++) { //找到最大值，及其对应的下标
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);

        if (right - left == 1) return root; //叶子节点

        //递归构造左右子树
        root.left = traversal(nums, left, maxValueIndex);
        root.right = traversal(nums, maxValueIndex + 1, right);
        return root;
    }
}
