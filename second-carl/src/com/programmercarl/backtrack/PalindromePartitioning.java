package com.programmercarl.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。
 * 返回 s 所有可能的分割方案。
 */
public class PalindromePartitioning {
    List<List<String>> result;
    List<String> path;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();

        backtracking(s, 0);

        return result;
    }

    public void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {  //递归终止，收集结果
            result.add(new ArrayList(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1); //截取[startIndex,i+1)范围内的子串
            if (isPalindrome(sub)) {  //如果是回文串

                path.add(sub);   //path加入子串

                backtracking(s, i + 1);  //递归

                path.remove(path.size() - 1);  //回溯
            }
        }
    }

    //判断sub是否是回文字符串
    public boolean isPalindrome(String sub) {
        if (sub.length() == 1) return true;
        int left = 0;
        int right = sub.length() - 1;

        while (left < right) {
            if (sub.charAt(left) != sub.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
