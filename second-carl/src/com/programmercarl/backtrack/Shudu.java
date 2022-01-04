package com.programmercarl.backtrack;

public class Shudu {
    public void solveSudoku(char[][] board) {
        backtracking(board, 0);
    }

    private boolean backtracking(char[][] board, int row) {
        for (int i = row; i < board.length; i++) {  //从当前行开始遍历
            for (int j = 0; j < board[0].length; j++) {  //遍历列 ***注意,遍历列时从0开始***
                if (board[i][j] != '.') continue;   //如果是数字，则跳过

                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(board, k, i, j)) { //判断当前位置是否合法
                        board[i][j] = k;  //放置数字
                        if(backtracking(board, i)) return true;   //递归
                        board[i][j] = '.';  //回溯
                    }
                }
                return false;   //如果9个数字都试过了，也不行，则直接返回false
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, char val, int row, int col) {
        for (int i = 0; i < 9; i++) {  //检查行
            if (board[i][col] == val) return false;
        }

        for (int j = 0; j < 9; j++) {  //检查列
            if (board[row][j] == val) return false;
        }

        //检查九宫格
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }
        return true;
    }
}
