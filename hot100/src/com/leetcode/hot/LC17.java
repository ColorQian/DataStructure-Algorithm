package com.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * 17. 电话号码的字母组合
 */
public class LC17 {
    List<String> result;
    String[] numStr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder builder = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() == 0) return result;

        backtracking(digits, 0);

        return result;
    }

    public void backtracking(String digits, int index) {
        if (index == digits.length()) {
            result.add(builder.toString());
            return;
        }

        String str = numStr[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));  // 处理节点

            backtracking(digits, index + 1); // 递归

            builder.deleteCharAt(builder.length() - 1); // 回溯
        }
    }
}
