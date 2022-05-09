package com.jianzhi.master3;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/IDBivT/
 * 剑指 Offer II 085. 生成匹配的括号
 */
public class Question85 {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();

        dfs(n, n, "");

        return result;
    }

    public void dfs(int left, int right, String s) {
        if (left == 0 && right == 0) {
            result.add(s);
        }

        if (left > right) return;

        if (left > 0) {
            dfs(left - 1, right, s + "(");
        }

        if (right > 0) {
            dfs(left, right - 1, s + ")");
        }
    }
}
