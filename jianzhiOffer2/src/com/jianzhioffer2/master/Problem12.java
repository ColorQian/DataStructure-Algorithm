package com.jianzhioffer2.master;

public class Problem12 {
    // 递归 + 回溯
    String s;
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board == null || word.length() == 0) return false;
        s = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;
        //以下为剪枝操作
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (k < s.length()) {
            if (s.charAt(k) != board[i][j]) return false;
        }
        // 递归终止条件
        if (k == s.length() - 1) return true; // 最后一个也匹配上，返回true

        // 走到这里，说明匹配上，需要将匹配上的位置 置空，这是为了防止递归时重复匹配
        board[i][j] = ' ';

        // 递归
        boolean res = dfs(board, i + 1, j, k + 1) || dfs(board, i - 1, j, k + 1) ||
                dfs(board, i, j + 1, k + 1) || dfs(board, i, j - 1, k + 1);

        // 回溯
        board[i][j] = s.charAt(k);

        return res;
    }
}
