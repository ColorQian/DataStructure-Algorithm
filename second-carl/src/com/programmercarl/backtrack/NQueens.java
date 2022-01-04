package com.programmercarl.backtrack;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * N皇后问题
 */
public class NQueens {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();

        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }

        backtracking(n, 0, chessboard);

        return result;
    }

    public void backtracking(int n, int row, char[][] chessboard) {
        if (row == n) {
            result.add(Array2List(chessboard));  //char[][] chessboard -> List<String>
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) { //如果棋盘上当前的位置(row, col)合法，则放置棋子
                chessboard[row][col] = 'Q';  //放置棋子
                backtracking(n, row + 1, chessboard); //递归下一行
                chessboard[row][col] = '.';  //回溯
            }
        }
    }

    //该方法可以将char[][] chessboard ---> List<String>
    public List<String> Array2List(char[][] chessboard) {
        List<String> path = new ArrayList<>();

        for (char[] c : chessboard) {
            path.add(String.copyValueOf(c));  //copyValueOf: char[] -> String
        }
        return path;
    }

    //需要检查当前位置所在的行列，对角线上是否已经被放置过皇后了(由于每次都是递归不同的行，所以行不用再检查了)
    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        //检查不同的列
        for (int i = 0; i < row; i++) {  //注意剪枝
            if (chessboard[i][col] == 'Q') return false;
        }

        //检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) { //注意起始位置
            if (chessboard[i][j] == 'Q') return false;
        }

        //检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') return false;
        }

        return true;
    }
}
