package com.jianzhioffer2.master;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/submissions/
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class Problem33 {
    public boolean verifyPostorder(int[] postorder) {
        return traversal(postorder, 0, postorder.length - 1);
    }

    private boolean traversal(int[] postorder, int i, int j) {
        if (i >= j) return true;  // 只有一个节点

        int midIndex = i;
        while (postorder[midIndex] < postorder[j]) midIndex++;

        // 程序走到这里，找到当前根节点的右子树了
        int pivot = midIndex;    // 保留右子树下标
        while (postorder[midIndex] > postorder[j]) midIndex++;

        // 判断当前节点是否是根  递归判断 左右子树 是否满足情况
        return j == midIndex && traversal(postorder, i, pivot - 1) && traversal(postorder, pivot, j - 1);
    }
}
