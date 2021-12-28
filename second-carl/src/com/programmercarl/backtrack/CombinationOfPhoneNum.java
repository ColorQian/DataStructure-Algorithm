package com.programmercarl.backtrack;

import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 */
public class CombinationOfPhoneNum {
    //建立数字和字母的映射关系，下标表示数字，str[i]表示对应字母
    String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result;
    StringBuilder temp;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        temp = new StringBuilder();

        if (digits.length() == 0) return result;

        backtracking(digits, 0);

        return result;
    }

    public void backtracking(String digits, int index) {
        if (temp.length() == digits.length()) {  //递归终止条件
            result.add(temp.toString());
            return;
        }

        //byte,short,char混合运算的时候，先各自转换为int类型再做运算
        String numStr = str[digits.charAt(index) - '0'];  //str['2' - '0'] -> str[2]
        for (int i = 0; i < numStr.length(); i++) {
            temp.append(numStr.charAt(i));  //处理节点

            backtracking(digits, index + 1); //递归

            temp.deleteCharAt(temp.length() - 1);  //回溯
        }
    }
}
