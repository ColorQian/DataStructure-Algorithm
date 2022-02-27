package com.jianzhioffer2.array;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 二维数组中的查找(把二维数组看做一颗二叉搜索树，按规律查找，根节点可以为右上角或左下角)
 */
public class SearchIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length ==  0 || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        int flag = matrix[row][col];

        while (row <= matrix.length - 1 && col >= 0) {
            flag = matrix[row][col];
            if (flag < target) row++;
            else if (flag > target) col--;
            else return true;
        }
        return false;
    }
}
